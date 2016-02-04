/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author jaimin
 */
public class createTestCase {

    public static void main(String[] args) throws IOException, Exception {
        PrintWriter out = new PrintWriter(System.out);

        int t = createTest(1, 5);
        out.println(t);
        EmptyBST e = new EmptyBST();
        NonEmptyBST n = new NonEmptyBST(createTest(1, 200));

        for (int i=0;i<t;i++) {
            Testers.rndTree(createTest(1, 200));
            out.print(n.data);
            Testers.checkAddMemberCardinality(n, createTest(1, 200));
        }
        out.flush();
        out.close();
    }

    static int createTest(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt(max - min + 1) + min;
    }

}

interface Tree<D extends Comparable> {

    public boolean isEmpty();

    public int cardinality();

    public boolean member(D elt);

    public NonEmptyBST<D> add(D elt);
}

class NonEmptyBST<D extends Comparable> implements Tree<D> {

    D data;
    Tree<D> left;
    Tree<D> right;

    public NonEmptyBST(D elt) {
        data = elt;
        left = new EmptyBST<D>();
        right = new EmptyBST<D>();
    }

    public NonEmptyBST(D elt, Tree<D> leftTree, Tree<D> rightTree) {
        data = elt;
        left = leftTree;
        right = rightTree;
    }

    public boolean isEmpty() {
        return false;
    }

    public int cardinality() {
        return 1 + left.cardinality() + right.cardinality();
    }

    public boolean member(D elt) {
        if (data == elt) {
            return true;
        } else {
            if (elt.compareTo(data) < 0) {
                return left.member(elt);
            } else {
                return right.member(elt);
            }
        }
    }

    public NonEmptyBST<D> add(D elt) {
        if (data == elt) {
            return this;
        } else {
            if (elt.compareTo(data) < 0) {
                return new NonEmptyBST(data, left.add(elt), right);
            } else {
                return new NonEmptyBST(data, left, right.add(elt));
            }
        }
    }

}

class EmptyBST<D extends Comparable> implements Tree<D> {

    public EmptyBST() {

    }

    public boolean isEmpty() {
        return true;
    }

    public int cardinality() {
        return 0;
    }

    public boolean member(D elt) {
        return false;
    }

    public NonEmptyBST<D> add(D elt) {
        return new NonEmptyBST<D>(elt);
    }

}

class Testers {

    // random integers
    public static int rndInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
        // min = 5, max = 15       
        // 15 - 5 = 10 + 1 == 11 --> 0 to 10
        // + 5 to this random number
    }

    // random binary search trees
    public static Tree rndTree(int count) {
        if (count == 0) {
            return new EmptyBST();
        } else {
            return rndTree(count - 1).add(rndInt(0, 50));
        }
    }

    // x + (x * 2) = x + x * 2 
    public static void checkIsEmpty(Tree t) throws Exception {
        // if the tree t is an instance of EmptyBST --> t.isEmpty -> true
        // if the tree t is an instance of NonEmptyBST --> t.isEmpty -> false
        if (t instanceof EmptyBST) {
            if (!t.isEmpty()) {
                throw new Exception("All is not good, the tree is an EmptyBST and it is non-empty");
            }
        } else if (t instanceof NonEmptyBST) {
            if (t.isEmpty()) {
                throw new Exception("All is not good, the tree is a NonEmptyBST and it is empty");
            }
        }
    }

    public static void checkAddMemberCardinality(Tree t, int x) throws Exception {
        int nT = (t.add(x)).cardinality();
        // 1. Either something was added -> and the cardinality increased by one.
        if (nT == (t.cardinality() + 1)) {
            if (t.member(x)) {
                throw new Exception("The cardinality increased by 1, but the thing"
                        + " that was added was already a member of the tree");
            } // else {
               // System.out.println("All is good, our cardinality increased and the thing wasn't in the tree");
           //}
        } // 2. OR the thing that was added was already there and therefore not really added
        // so the cardinality stayed the same. 
        else if (nT == t.cardinality()) {
            if (!t.member(x)) {
                throw new Exception("The cardinality didn't increased by 1, but"
                        + " we added a new thing");
            } // else {
              //  System.out.println("All is good, the thing was in the tree already and our cardinality didn't increase");
            // }
        } else {
            throw new Exception("Something is wrong with our program");
        }
        
    }

}
