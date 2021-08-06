import java.util.*;

class Program {
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

		// Average O(logn) time; O(1) extra space  
		// Worst O(n); O(1) extra space
    public BST insert(int value) {
      // Iterative solution is better from a space point of view. 
			BST currentNode = this;  
			while (true) { 
				if (value < currentNode.value) { 
					if (currentNode.left == null) { 
						currentNode.left = new BST(value); 
						break; 
					} else { 
						currentNode = currentNode.left; 
					}
				} else { 
					if (currentNode.right == null) { 
						currentNode.right = new BST(value); 
						break; 
					} else { 
						currentNode = currentNode.right; 
					}
				}
			} 
      return this;
    }

		// Avg: O(logn); space O(1)
    public boolean contains(int value) {
      BST currentNode = this;  
			while (currentNode != null) { 
				if (value < currentNode.value) { 
					currentNode = currentNode.left; 
				} else if (value > currentNode.value) { 
					currentNode = currentNode.right; 
				} else { 
					return true; 
				}
			}
      return false;
    }
		
		public int getMinValue() { 
			if (left == null) { 
				return value; 
			} else { 
				return left.getMinValue();
			} 
		}
	
		public BST remove(int value) { 
			remove(value, null); 
			return this; 
		}

		// Difficult one because of the edge cases 
    public BST remove(int value, BST parentNode) {
			BST currentNode = this;  
			// First find the value you're trying to remove 
			while (currentNode != null) { 
				if (value < currentNode.value) { 
					parentNode = currentNode; 
					currentNode = currentNode.left; 
				} else if (value > currentNode.value) { 
					parentNode = currentNode; 
					currentNode = currentNode.right; 
				} else { 
					// Found the node 
					// Case 1: Node has two children node -> use smallest node in the right subtree 
					if (currentNode.left != null && currentNode.right != null) { 
							currentNode.value = currentNode.right.getMinValue(); 
							currentNode.right.remove(currentNode.value, currentNode); 
					// Case 2: 1 child present (1. with parent 2. without parent)
					} else if (parentNode == null) { 
							if (currentNode.left != null) { 
								currentNode.value = currentNode.left.value; 
								currentNode.right = currentNode.left.right; 
								currentNode.left = currentNode.left.left; 
							} else if (currentNode.right != null) { 
								currentNode.value = currentNode.right.value; 
								currentNode.left = currentNode.right.left; 
								currentNode.right = currentNode.right.right;  
							} else { 
								// No children nodes (banal edge case) Deleting the BST 
								// currentNode.value = null; 
							}
					} else if (parentNode.left == currentNode) { 
							parentNode.left = (currentNode.left != null) ? currentNode.left : currentNode.right; 
					} else if (parentNode.right == currentNode) { 
							parentNode.right = (currentNode.left != null) ? currentNode.left : currentNode.right; 
					}
					break; 
				}
			}
      return this;
    }
  }
}
