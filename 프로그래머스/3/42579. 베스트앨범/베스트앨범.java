import java.util.*;

class Solution {
            public int[] solution(String[] genres, int[] plays) {

                Map<String, Integer> genreMap = new HashMap<>();
                Map<String, List<Integer>> playMap = new HashMap<>();

                for(int i = 0; i < genres.length; i++) {

                    genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

                    List<Integer> indexList = playMap.getOrDefault(genres[i], new ArrayList<>());

                    indexList.add(i);

                    playMap.put(genres[i], indexList);

                }

                List<Integer> sumList = new ArrayList<>(genreMap.values());

                sumList.sort(Comparator.reverseOrder());

                Iterator genreItr = genreMap.keySet().iterator();

                Map<Integer, String> sumMap = new HashMap<>();

                while (genreItr.hasNext()) {

                    String genre = (String)genreItr.next();

                    sumMap.put(genreMap.get(genre), genre);

                    List<Integer> indexList = playMap.get(genre);

                    List<Integer> playList = new ArrayList<>();
                    
                    Map<Integer, Queue<Integer>> twoMap = new HashMap<>();

                    for (int i : indexList) {

                        playList.add(plays[i]);
                        
                        if (!twoMap.containsKey(plays[i])) {
                            Queue<Integer> que = new LinkedList<>();
                            que.offer(i);
                            twoMap.put(plays[i], que);
                        } else {
                            Queue<Integer> que = twoMap.get(plays[i]);
                            que.offer(i);
                            twoMap.put(plays[i], que);
                        }
                    }

                    playList.sort(Comparator.reverseOrder());
                    
                    indexList.clear();
                                    
                    indexList.add(twoMap.get(playList.get(0)).poll());
                    if (playList.size() > 1) {
                        indexList.add(twoMap.get(playList.get(1)).poll());
                    }
                    
                    playMap.put(genre, indexList);

                }

                List<Integer> answerList = new ArrayList<>();

                for(int i = 0; i < sumList.size(); i++) {

                    String genre = sumMap.get(sumList.get(i));

                    answerList.addAll(playMap.get(genre));

                }
                
                int[] answer = new int[answerList.size()];

                for (int i = 0; i < answerList.size(); i++) {
                    
                    answer[i] = answerList.get(i);
                    
                }

                return answer;
            }
}