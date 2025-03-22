package vidya.code.chalenge.study;

import java.util.*;

class Node {
  public Node[] subtrees;
  public Node(Node[] subtrees) {
    this.subtrees = subtrees;
  }
}

public class BalanceTreeCount {
  // Helper function to calculate the size of a subtree
  private static int calculateSubtreeSize(Node node) {
    if (node == null) return 0;
    int size = 1; // Count the current node
    for (Node subtree : node.subtrees) {
      size += calculateSubtreeSize(subtree);
    }
    return size;
  }

  // Helper function to check if a node is balanced
  private static boolean isBalanced(Node node) {
    if (node.subtrees == null || node.subtrees.length == 0) return true; // Leaf nodes are balanced

    int subtreeSize = calculateSubtreeSize(node.subtrees[0]);
    for (Node subtree : node.subtrees) {
      if (calculateSubtreeSize(subtree) != subtreeSize) {
        return false;
      }
    }
    return true;
  }

  // Main function to count the number of balanced nodes
  public static int countBalancedNodes(Node root) {
    if (root == null) return 0;

    int count = 0;
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node current = stack.pop();
      if (isBalanced(current)) {
        count++;
      }
      if (current.subtrees != null) {
        for (Node subtree : current.subtrees) {
          stack.push(subtree);
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {
    // Example tree
    Node leaf1 = new Node(new Node[] {});
    Node leaf2 = new Node(new Node[] {});
    Node leaf3 = new Node(new Node[] {});
    Node subtree1 = new Node(new Node[] {leaf1, leaf2});
    Node subtree2 = new Node(new Node[] {leaf3});
    Node root = new Node(new Node[] {subtree1, subtree2});

    System.out.println("Number of balanced nodes: " + countBalancedNodes(root));
  }
}
