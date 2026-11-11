class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;

        int a[]= new int[m+n];
        int i=0, j=0, k=0;

        while(i<n && j<m){
          if(nums1[i]<nums2[j]){
          a[k++]=nums1[i++];
          }else{
            a[k++]=nums2[j++];
          }
        }
        while (i < n) a[k++] = nums1[i++];
        while (j < m) a[k++] = nums2[j++];

        int l=n+m;
        if(l %2==1){
            return a[l/2];
        }else{
            return (a[l / 2 - 1] + a[l / 2]) / 2.0;
        }

    }
}