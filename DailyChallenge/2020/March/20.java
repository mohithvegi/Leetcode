//https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3678/


class UndergroundSystem {
    Map<Integer, String> checkInMap;
    Map<String, Integer> timeMap;
    Map<String, Integer> countMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        timeMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, stationName + "," + t);
    }

    public void checkOut(int id, String stationName, int t) {
        String val = checkInMap.get(id);
        String prevStationName = val.split(",")[0];
        int prevTime = Integer.parseInt(val.split(",")[1]);
        String key = prevStationName + "|" + stationName;
        timeMap.put(key, timeMap.getOrDefault(key, 0) + t - prevTime);
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "|" + endStation;
        return ((double) timeMap.get(key)) / countMap.get(key);
    }
}