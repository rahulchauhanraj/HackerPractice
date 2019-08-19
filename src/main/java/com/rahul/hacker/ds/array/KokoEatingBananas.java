package com.rahul.hacker.ds.array;

import org.springframework.util.Assert;

/**
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 *
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 *
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 *
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] a, int k) {

        if(a == null || a.length==0){
            return 0;
        }

        int l = a.length;
        int max = getMax(a);
        int left = 1;
        int right = max;

        while(left<=right){

            int mid = left + (right-left)/2;

            long hour = getHours(a, mid, l);

            if(hour == k) {
                return mid;
            }

            if (hour >= k) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }

        return left;
    }

    private long getHours(int a[], int i, int l) {

        long hour = 0;

        for(int j = 0;j<l;j++){

            if(a[j] % i == 0){
                hour += a[j]/i;
            } else {
                hour += a[j]/i +1;
            }
        }

        return hour;
    }

    private int getMax(int[] a){
        int max = a[0];

        for(int i =1;i<a.length; i++){
            if(a[i] > max){
                max = a[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] a = {873375536, 395271806, 617254718, 970525912, 634754347, 824202576, 694181619, 20191396, 886462834, 442389139, 572655464, 438946009,
                791566709, 776244944, 694340852, 419438893, 784015530, 588954527, 282060288, 269101141, 499386849, 846936808, 92389214, 385055341,
                56742915, 803341674, 837907634, 728867715, 20958651, 167651719, 345626668, 701905050, 932332403, 572486583, 603363649, 967330688,
                484233747, 859566856, 446838995, 375409782, 220949961, 72860128, 998899684, 615754807, 383344277, 36322529, 154308670, 335291837,
                927055440, 28020467, 558059248, 999492426, 991026255, 30205761, 884639109, 61689648, 742973721, 395173120, 38459914, 705636911,
                30019578, 968014413, 126489328, 738983100, 793184186, 871576545, 768870427, 955396670, 328003949, 786890382, 450361695, 994581348,
                158169007, 309034664, 388541713, 142633427, 390169457, 161995664, 906356894, 379954831, 448138536};
        int b = new KokoEatingBananas().minEatingSpeed(a, 943223529);
        Assert.isTrue(46 == b);
        a = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184};
        b = new KokoEatingBananas().minEatingSpeed(a, 823855818);
        Assert.isTrue(14 == b);
    }
}
