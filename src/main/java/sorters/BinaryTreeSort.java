package sorters;

import exceptions.ChildNotFoundException;

import interfaces.BinaryTreeInterface;
import interfaces.Sorter;

import managers.InputManager;
import managers.OutputManager;

/**
 * This class implements the binary tree sort algorithm.
 * See https://tutorialspoint.dev/algorithm/sorting-algorithms/tree-sort
 * for explanation of binary tree sort algorithm.
 * This class implements methods BinaryTreeInterface as well as Sorter.
 */
public class BinaryTreeSort implements BinaryTreeInterface, Sorter {

    /**
     * The root node is the base value from which the rest of the tree
     * will 'grow' from. In this application the first value in the
     * unsorted array will always be made the root node.
     */
    private Node rootNode;

    /**
     * Will equal the number of unique values added to the tree
     * as this method does not handle duplicate values in the
     * unsorted array, it just ignores them.
     */
    private int  numberOfElements = 0;

    /**
     * This int will represent the index of the unpopulated
     * sortedArray which the next smallest value in the tree
     * will occupy. It will increment every time a value is
     * added to the sortedArray.
     */
    private int  nodeIndex = 0;

    /**
     * Begins as a null array. It will be initialised to have the
     * same length as the number of unique values in the tree, then
     * it will be populated with those unique values as the tree
     * is traversed.
     */
    int[] sortedArray;

    /**
     * Override Sorter interface method to return name of sorting method.
     * @return "Binary Tree Sort"
     */
    @Override
    public String getSorterName() {

        return "Binary Tree Sort";

    }

    /**
     * Override Sorter interface method to initiate binary tree sort.
     * @param arrayToSort unsorted array of random integers.
     * @return sorted array by calling getSortedTreeAsc()
     */
    @Override
    public int[] sortArray(int[] arrayToSort) {

        initBinaryTree(arrayToSort);

        return getSortedTreeAsc();
    }

    /**
     * Set the root node as the first value in the unsorted array,
     * increment numberOfElements by 1 as a result.
     * Add the rest of the values in the unsorted array to the tree
     * and set sortedArray to have the same length as the number
     * of unique values in the tree.
     * @param arrayToSort unsorted array of random integers.
     */
    private void initBinaryTree(int[] arrayToSort) {

        rootNode = new Node(arrayToSort[0]);
        numberOfElements++;
        addElements(arrayToSort);
        sortedArray = new int[getNumberOfElements()];
    }

    /**
     * Return the int value of the root element.
     * @return value of root node.
     */
    @Override
    public int getRootElement() {

        return rootNode.getVALUE();

    }

    /**
     * Return the number of unique values in the tree.
     * @return number of unique values.
     */
    @Override
    public int getNumberOfElements() {

        return numberOfElements;

    }

    /**
     * Add unique values from the unsorted array to the
     * tree. Skip the first (0th) value because it has
     * already been set as the root node.
     * @param elements unsorted array from index 1.
     */
    @Override
    public void addElements(int[] elements) {
        for(int i = 1; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    /**
     * Add the first (0th) value from the unsorted array
     * as the root node of the tree.
     * @param element unsorted array index 0.
     */
    @Override
    public void addElement(final int element) {

        addNodeToTree(rootNode, element);

    }

    /**
     * Unused method from BinaryTreeInterface
     * @param value value
     * @return boolean
     */
    @Override
    public boolean findElement(int value) {

        return false;

    }

    /**
     * Use the argument value to find the node object assigned to it.
     * From there check if that node has a child to its left (a lower value).
     * If there is a child there, return its value. Otherwise throw
     * ChildNotFoundException.
     * @param element value of the parent node against which the method will try to find a left child.
     * @return value of the child to the left of the parent node.
     * @throws ChildNotFoundException thrown if the parent node has no child to its left.
     */
    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        int nextElement;

        if(node.isLeftChildEmpty()) {
            throw new ChildNotFoundException();
        } else {
            Node nextNode = node.getLeftChild();
            nextElement = nextNode.getVALUE();
        }

        return nextElement;
    }

    /**
     * Use the argument value to find the node object assigned to it.
     * From there check if that node has a child to its right (a higher value).
     * If there is a child there, return its value. Otherwise throw
     * ChildNotFoundException.
     * @param element value of the parent node against which the method will try to find a right child.
     * @return value of the child to the right of the parent node.
     * @throws ChildNotFoundException thrown if the parent node has no child to its right.
     */
    @Override
    public int getRightChild(int element) throws ChildNotFoundException {

        Node node = findNode(element);
        int nextElement;

        if(node.isRightChildEmpty()) {
            throw new ChildNotFoundException();
        } else {
            Node nextNode = node.getRightChild();
            nextElement = nextNode.getVALUE();
        }

        return nextElement;
    }

    /**
     * Call traverseTreeAsc from the root node and to set the first value
     * of the sorted array (nodeIndex = 0 at this point always). The method
     * traverseTreeAsc will recursively call itself until sortedArray has
     * been filled and this method can finally return the sorted array.
     * @return sorted array.
     */
    @Override
    public int[] getSortedTreeAsc() {

        traverseTreeAsc(getRootElement(), nodeIndex);

        return sortedArray;

    }

    /**
     * Unused at this version of the application.
     * @return null
     */
    @Override
    public int[] getSortedTreeDesc() {

        traverseTreeDesc(getRootElement(), nodeIndex);

        return sortedArray;

    }

    /**
     * This method will always be called with the root node and index 0
     * first. The method will try to go as far left down the tree as it
     * can until there is no left child present, then it will assign
     * that value to the current nodeIndex of sortedArray, increment nodeIndex
     * by 1, then try and go down the right side of the tree. The method
     * calls itself recursively until it has a null node as its argument.
     * @param element value of current node
     * @param index index of sortedArray to assign value to
     */
    private void traverseTreeAsc(int element, int index) {
        Node node = findNode(element);
        if(node != null) {
            try {
                traverseTreeAsc(getLeftChild(node.getVALUE()), nodeIndex);
            } catch (ChildNotFoundException e) {
                OutputManager.logger.debug(e.toString());
            }
            sortedArray[nodeIndex] = element;
            nodeIndex++;
            try {
                traverseTreeAsc(getRightChild(node.getVALUE()), nodeIndex);
            } catch (ChildNotFoundException e) {
                OutputManager.logger.debug(e.toString());
            }
        }
    }

    /**
     * Unused at this version of the application.
     * @param element value of current node
     * @param index index of sortedArray to assign value to
     */
    private void traverseTreeDesc(int element, int index) {

        Node node = findNode(element);
        if(node != null) {
            try {
                traverseTreeAsc(getRightChild(node.getVALUE()), nodeIndex);
            } catch (ChildNotFoundException e) {
                OutputManager.logger.debug(e.toString());
            }
            sortedArray[nodeIndex] = element;
            nodeIndex++;
            try {
                traverseTreeAsc(getLeftChild(node.getVALUE()), nodeIndex);
            } catch (ChildNotFoundException e) {
                OutputManager.logger.debug(e.toString());
            }
        }
    }

    /**
     * Unused at this version of the application.
     * @return null
     */
    private int[] userChoice() {

        OutputManager.userMessage("Select from the following:");
        OutputManager.userMessage("1. Sort in ASCENDING order");
        OutputManager.userMessage("2. Sort in DESCENDING order");
        OutputManager.userMessage("Select order by number::  ");
        int selection = InputManager.getUserInput();

        if(selection == 1) {
            return getSortedTreeAsc();
        } else if(selection == 2) {
            return getSortedTreeDesc();
        } else {
            OutputManager.userMessage("Please select 1 or 2");
            userChoice();
        }

        return null;
    }

    /**
     * If the argument value is equal to the argument node,
     * return null to ignore duplicate value. Otherwise compare
     * argument value to value of argument node to determine if it
     * will be a right child or a left child. Then check if their is
     * an empty child node to assign the argument value to and if their
     * isn't, recursively call the method with the same argument value,
     * but the occupied child as the argument node. This will recur
     * until the value is assigned its own node.
     * @param node node the new value will be compared against.
     * @param element the value which needs to be added to the tree.
     */
    private void addNodeToTree(Node node, int element) {
        if(element == node.getVALUE()) return;

        if(element < node.getVALUE()) {
            if(node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
                numberOfElements++;
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if(element > node.getVALUE()) {
            if(node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
                numberOfElements++;
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    /**
     * Start at the root node. Compare the argument value to the
     * value of the current node. If they're equal then return that node,
     * otherwise go to the next appropriate child node and check against that.
     * @param element value for which there should be a corresponding node.
     * @return node object of the argument value.
     */
    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if(element == node.getVALUE()) {
                return node;
            }

            if(element < node.getVALUE()) {
                node = node.getLeftChild();
            } else if(element > node.getVALUE()){
                node = node.getRightChild();
            }
        }
        return null;
    }

    /**
     * Instantiate a new node, set its value and store its children.
     */
    public static class Node {

        private final int VALUE;
        private Node leftChild;
        private Node rightChild;

        public Node(int VALUE) {

            this.VALUE = VALUE;

        }

        public int getVALUE() {

            return VALUE;

        }

        public Node getLeftChild() {

            return leftChild;

        }

        public void setLeftChild(Node leftChild) {

            this.leftChild = leftChild;

        }

        public Node getRightChild() {

            return rightChild;

        }

        public void setRightChild(Node rightChild) {

            this.rightChild = rightChild;

        }

        public boolean isLeftChildEmpty() {

            return leftChild == null;

        }

        public boolean isRightChildEmpty() {

            return rightChild == null;

        }
    }
}

