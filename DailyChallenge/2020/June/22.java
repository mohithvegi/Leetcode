// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/

class Solution {
      private Map<Character, List<Integer>> map;
      public int numMatchingSubseq(String S, String[] words) {
          this.map = new HashMap<>();
          for(int i = 0; i < S.length(); i++){
              char c = S.charAt(i);
              List<Integer> list = map.containsKey(c) ? map.get(c): new ArrayList<>();
              list.add(i);
              map.put(c, list);
          }
          int res = 0;
          for(String word : words){
              if(match(word)) res++;
          }
          return res;
      }
      private boolean match(String s){
          char[] arr = s.toCharArray();
          int pre = -1;
          for(char c : arr){
              if(!map.containsKey(c)) return false;
              List<Integer> list = map.get(c);
              int index = Collections.binarySearch(list, pre + 1);
              if(index < 0) index = -index - 1;
              if(index >= list.size()) return false;
              pre = list.get(index);
          }
          return true;
      }
  }
