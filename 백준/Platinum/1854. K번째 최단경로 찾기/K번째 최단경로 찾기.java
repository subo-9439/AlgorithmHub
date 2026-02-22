import java.io.*;
import java.util.*;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    /** 전역 PQ에 들어갈 상태(노드, 현재까지 거리) */
    static class NodeState {
        int nodeId;
        long totalCost;

        NodeState(int nodeId, long totalCost) {
            this.nodeId = nodeId;
            this.totalCost = totalCost;
        }
    }

    // 입력 값
    static int nodeCount;        // N
    static int edgeCount;        // M
    static int kthShortestIndex; // K (k번째 최단)

    // 인접 리스트(배열 방식)
    static int[] firstEdgeIndexByNode; // head
    static int[] toNode;               // to
    static int[] nextEdgeIndex;        // next
    static int[] edgeCost;             // w
    static int edgePtr = 0;

    static void addDirectedEdge(int from, int to, int cost) {
        toNode[edgePtr] = to;
        edgeCost[edgePtr] = cost;
        nextEdgeIndex[edgePtr] = firstEdgeIndexByNode[from];
        firstEdgeIndexByNode[from] = edgePtr++;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        nodeCount = fr.nextInt();
        edgeCount = fr.nextInt();
        kthShortestIndex = fr.nextInt();

        firstEdgeIndexByNode = new int[nodeCount + 1];
        Arrays.fill(firstEdgeIndexByNode, -1);

        toNode = new int[edgeCount];
        nextEdgeIndex = new int[edgeCount];
        edgeCost = new int[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();
            int cost = fr.nextInt();
            addDirectedEdge(from, to, cost); // 유향
        }

        // node별로 "최단거리 후보 k개"만 유지 (max-heap: peek() = 현재 저장된 후보 중 가장 큰 값 = k번째 후보)
        @SuppressWarnings("unchecked")
        PriorityQueue<Long>[] topKDistancesByNode = new PriorityQueue[nodeCount + 1];
        for (int node = 1; node <= nodeCount; node++) {
            topKDistancesByNode[node] = new PriorityQueue<>(Collections.reverseOrder());
        }

        // 전체 확장용 PQ (min-heap: 거리 작은 것부터)
        PriorityQueue<NodeState> expansionQueue =
                new PriorityQueue<>(Comparator.comparingLong(s -> s.totalCost));

        // 시작 노드(1) 초기화
        topKDistancesByNode[1].offer(0L);
        expansionQueue.offer(new NodeState(1, 0L));

        while (!expansionQueue.isEmpty()) {
            NodeState current = expansionQueue.poll();
            int currentNode = current.nodeId;
            long currentCost = current.totalCost;

            // 이미 currentNode에 대해 k개가 차 있고, k번째 후보(가장 큰 값)보다 큰 "오래된 상태"면 버림
            if (topKDistancesByNode[currentNode].size() == kthShortestIndex
                    && topKDistancesByNode[currentNode].peek() < currentCost) {
                continue;
            }

            // 인접 간선 순회
            for (int edgeIdx = firstEdgeIndexByNode[currentNode];
                 edgeIdx != -1;
                 edgeIdx = nextEdgeIndex[edgeIdx]) {

                int nextNode = toNode[edgeIdx];
                long nextCost = currentCost + (long) edgeCost[edgeIdx];

                PriorityQueue<Long> topKForNext = topKDistancesByNode[nextNode];

                // k개 미만이면 그냥 추가
                if (topKForNext.size() < kthShortestIndex) {
                    topKForNext.offer(nextCost);
                    expansionQueue.offer(new NodeState(nextNode, nextCost));
                }
                // k개 꽉 찼으면, 현재 k번째 후보보다 더 좋은 경우에만 교체
                else if (topKForNext.peek() > nextCost) {
                    topKForNext.poll();
                    topKForNext.offer(nextCost);
                    expansionQueue.offer(new NodeState(nextNode, nextCost));
                }
            }
        }

        // 출력: 각 노드의 k번째 최단거리(없으면 -1)
        StringBuilder out = new StringBuilder();
        for (int node = 1; node <= nodeCount; node++) {
            PriorityQueue<Long> topK = topKDistancesByNode[node];
            out.append(topK.size() < kthShortestIndex ? -1 : topK.peek()).append('\n');
        }
        System.out.print(out);
    }
}