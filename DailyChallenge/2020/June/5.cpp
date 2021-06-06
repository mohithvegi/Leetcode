// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3768/

class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<pair<int, int>> ess;
        for (int i = 0; i < n; i++){
            ess.push_back({efficiency[i], speed[i]});
        }
        //sort by efficiency and then by speed, descending
        sort(ess.rbegin(), ess.rend());

        long sumS = 0, res = 0;
        priority_queue <int, vector<int>, greater<int> > pq;
        //itereate through efficiency
        for (int i = 0; i < n; i++) {
            //for each efficiency, find the maximum possible combination(of size <= k) of speed
            //possible speeds are the speed whose efficiency >= current efficiency
            pq.push(ess[i].second);
            //sumS: the sum of the combination of speed for current efficiency
            sumS += ess[i].second;
            // cout << "push " << ess[i].second << ", sumS: " << sumS << endl;
            if (pq.size() > k) {
                sumS -= pq.top();
                // cout << "pop " << pq.top() << ", sumS: " << sumS << endl;
                pq.pop();
            }
            // cout << "current res: " << sumS * ess[i].first << endl;
            res = max(res, sumS * ess[i].first);
        }
        return res % (int)(1e9+7);
    }
};
