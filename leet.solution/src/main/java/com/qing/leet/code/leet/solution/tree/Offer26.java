package com.qing.leet.code.leet.solution.tree;

public class Offer26 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }

        if(A.val == B.val){
            return isSubStructure(A.left, B.left)&& isSubStructure(A.right, B.right);
        }
        isSubStructure(A.left, B);
        isSubStructure(A.right, B);



        return false;
    }
}
