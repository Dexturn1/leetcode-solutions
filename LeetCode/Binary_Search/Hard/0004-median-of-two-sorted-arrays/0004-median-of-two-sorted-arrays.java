class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int count = 0, i = 0, j = 0;
        int indx2 = n/2;
        int indx1 = indx2-1;
        int ind1el = -1;
        int ind2el = -1;

        while(i<n1 && j<n2){
            if(nums1[i] <nums2[j]){
                if(count == indx1) ind1el = nums1[i];
                if(count == indx2) ind2el = nums1[i];
                count++;
                i++;
            }else{
                if(count == indx1) ind1el = nums2[j];
                if(count == indx2) ind2el = nums2[j];
                count++;
                j++;
            }
        }

        while(i<n1){
            if(count == indx1) ind1el = nums1[i];
                if(count == indx2) ind2el = nums1[i];
                count++;
                i++;
        }
        while(j<n2){
                 if(count == indx1) ind1el = nums2[j];
                if(count == indx2) ind2el = nums2[j];
                count++;
                j++;
        }

        if(n%2==1){
            return ind2el;
        }else{
            return (double)(ind2el + ind1el)/2;
        }

    }
}