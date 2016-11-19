package edu.tsinghua.gaoyong.tree;

import java.util.LinkedList;

/**
 * 对树的一般节点的模拟，所有业务数据都抽象存储在value这个字符串当中
 * 求树的深度的非递归算法，可以利用哪种遍历方式做？层级遍历？
 * 
 * @author gaoyong
 *
 */
public class CustomTreeNode {
	
	//左子树
	private  CustomTreeNode leftNode;
	
	//右子树
	private CustomTreeNode rightNode;
	
	//存储的值
	private String value;
	
	public CustomTreeNode(){
		
	}
	
    public CustomTreeNode(String value){
		this.value = value;
	}

	public CustomTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(CustomTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public CustomTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(CustomTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isLeaf(){
		return leftNode == null &&leftNode == null;
	}
	
	
	
	@Override
	public String toString() {
		return value;
	}

	//左子树->根 —>右子树 的遍历方式 
	/**
	 * 采用递归的方式实现 先序遍历算法，对应地可以实现 中序遍历 和后序遍历
	 * @param root 根节点
	 */
	public void leftFirst(CustomTreeNode root){
		CustomTreeNode leftNode = root.getLeftNode();
		CustomTreeNode rightNode = root.getRightNode();
		if(leftNode != null){
			leftNode.leftFirst(leftNode);
		}
		//约定好每个节点的value值都不为空ß
		System.out.println(root.getValue());
		
		if(rightNode != null){
			rightNode.leftFirst(rightNode);
		}
	}
	
	public void inorder(CustomTreeNode root){
		CustomTreeNode leftNode = root.getLeftNode();
		CustomTreeNode rightNode = root.getRightNode();
		
		//约定好每个节点的value值都不为空ß
		System.out.println(root.getValue());
		
		if(leftNode != null){
			leftNode.inorder(leftNode);
		}
		
		
		if(rightNode != null){
			rightNode.inorder(rightNode);
		}
	}
	
	//左子树 右子树 根
	public void lrdOrder(CustomTreeNode root){
		CustomTreeNode leftNode = root.getLeftNode();
		CustomTreeNode rightNode = root.getRightNode();
		
		if(leftNode != null){
			leftNode.lrdOrder(leftNode);
		}
		
		if(rightNode != null){
			rightNode.lrdOrder(rightNode);
		}
		
		//约定好每个节点的value值都不为空
		System.out.println(root.getValue());
		
		
	}
	
	/**
	 * 用栈实现树的后序遍历，即左子树->右子树->根
	 * @param root
	 * @return
	 */
	public String postOrderByStack(CustomTreeNode root){
		LinkedList<CustomTreeNode> stack = new LinkedList<CustomTreeNode>();
		StringBuffer result = new StringBuffer();
		
		CustomTreeNode lastPopNode = null;//记录上次出栈的元素
		stack.push(root);//根节点入栈
		while(!stack.isEmpty()){
			CustomTreeNode node = stack.peek();//获取栈顶元素
			System.out.println("栈顶："+node.getValue());
			if(lastPopNode != null){
				System.out.println("上次出栈"+lastPopNode.getValue());
			}
			
			CustomTreeNode leftNode = node.getLeftNode();
			CustomTreeNode rightNode = node.getRightNode();
			
			//当前栈顶元素 左子树不为空，
			//上次出栈元素不是右子树 那么就左子树入栈
			
			if(leftNode != null){//左子树不为空
				//如果上次出栈的是右节点
				if(rightNode != null && lastPopNode !=null &&
						rightNode.getValue().equals(lastPopNode.getValue())){
					stack.pop();//出栈
					result.append(node.getValue() + ",");
					System.out.println(stack.toString());
					lastPopNode = node;
					continue;
				}
				
				//如果上次出栈的是左节点
				if(leftNode != null && lastPopNode !=null &&
						leftNode.getValue().equals(lastPopNode.getValue())){
					if(rightNode != null){
						stack.push(rightNode);
						System.out.println(stack.toString());
						continue;
					} else{//右子树为空，则直接出栈
						stack.pop();
						result.append(node.getValue() + ",");
						lastPopNode = node;
						System.out.println(node.getValue());
						System.out.println(stack.toString());
						continue;
					}
				}
				//出栈元素跟当前栈顶节点没关系，那么将左子树入栈
				if(lastPopNode != leftNode && lastPopNode != rightNode){
					stack.push(leftNode);
					System.out.println(stack.toString());
					continue;
				}
				
			}
			
			if(node.isLeaf()){ //如果是叶子节点直接出栈
				stack.pop();//出栈
				result.append(node.getValue() + ",");
				System.out.println(node.getValue());
				System.out.println(stack.toString());
				lastPopNode = node;
				continue;
			}
			
		}
		return result.toString();
		
	}
	
	//先序遍历 是最好实现的 遍历树算法，后序遍历要难于先序
	// 根 -->左子树 --> 右子树
	public String inOrderByStack(CustomTreeNode root){
		LinkedList<CustomTreeNode> stack = new LinkedList<CustomTreeNode>();
		
//		CustomTreeNode lastPopNode = null;//记录上次出栈的元素
		stack.push(root);//根节点入栈
		StringBuffer result = new StringBuffer();
		while(!stack.isEmpty()){
			CustomTreeNode node = stack.pop();//直接出栈栈顶元素
			System.out.println("栈顶"+node.getValue());
			CustomTreeNode leftNode = node.getLeftNode();
			CustomTreeNode rightNode = node.getRightNode();
			System.out.println("" + node.getValue());
			result.append(node.getValue() + "  ");
			
			if(rightNode != null){
				stack.push(rightNode);//将右子树入栈
				System.out.println(stack.toString());
			}
			if(leftNode != null){//将左子树入栈
				stack.push(leftNode);
				System.out.println(stack.toString());
			}
			
		}
		return result.toString();
	}
	
	//TODO 探讨的问题是为何要使用队列 而不使用栈 解决问题
	//也就是说，当我们遇到算法问题的时候，首先需要考虑的是采用哪一种数据结构来帮助解决问题
	/**
	 * 算法要求：层级遍历二叉树，从上到下，从左到右遍历
	 * 待实现的另一个算法，层级遍历 下到上，从左到右的遍历
	 * 采用栈 层级遍历树 有一点点困难
	 * 最适宜的算法是采用 队列解决问题，如何理解这个问题
	 * @param root
	 * @return
	 */
	public String layderOrderByQueue(CustomTreeNode root){
		StringBuffer result = new StringBuffer();
		LinkedList<CustomTreeNode> queue = new LinkedList<CustomTreeNode>();
		queue.offer(root);//加入到队列的末尾
		while(!queue.isEmpty()){//队列不为空
			CustomTreeNode node = queue.poll();
//			System.out.print(node.getValue() + ",");
			result.append(node.getValue() + ",");
			if(node.getLeftNode() != null){
				queue.offer(node.getLeftNode());
			}	
			
			if(node.getRightNode() != null){
				queue.offer(node.getRightNode());
			}
		}
			
		
		return result.toString();
	}
	
	/**
	 * 采用递归的办法计算树的深度
	 * 待实现的另一个算法实现 采用非递归的办法计算树的深度【学习任务】
	 * @param root
	 * @return
	 */
	public static int getTreeDepth(CustomTreeNode root){
		if(root == null){//传入null值，返回深度为0
			return 0;
		}
		CustomTreeNode leftNode = root.getLeftNode();
		CustomTreeNode rightNode = root.getRightNode();
		if(root.isLeaf()){//说明是叶子节点
			return 1;
		}else{//返回左右子树深度较大者加1
			int leftRreeDepth = CustomTreeNode.getTreeDepth(leftNode);
			int rightRreeDepth = CustomTreeNode.getTreeDepth(rightNode);
			if(leftRreeDepth > rightRreeDepth){
				return leftRreeDepth + 1;
			}else{
				return rightRreeDepth + 1;
			}
			
		}
	}
	
	
	
	
	public static void main(String[] args){
		CustomTreeNode root = new CustomTreeNode("root");
		//         rootValue
		//         /         \
		//        a            d
		//       / \          /  \
		//     b     c      e      f
		//                        /
		//                       g
		CustomTreeNode aNode = new CustomTreeNode("a");
		CustomTreeNode bNode = new CustomTreeNode("b");
		CustomTreeNode cNode = new CustomTreeNode("c");
		CustomTreeNode dNode = new CustomTreeNode("d");
		CustomTreeNode eNode = new CustomTreeNode("e");
		CustomTreeNode fNode = new CustomTreeNode("f");
		CustomTreeNode gNode = new CustomTreeNode("g");
		
		root.setLeftNode(aNode);
		root.setRightNode(dNode);
		aNode.setLeftNode(bNode);
		aNode.setRightNode(cNode);
		dNode.setLeftNode(eNode);
		dNode.setRightNode(fNode);
		
		fNode.setLeftNode(gNode);
		
		//上面初始化构建tree的过程可以写得再简化一些
//		root.leftFirst(root);
		//预期输出顺序b a c rootValue e d g f
		
//		root.inorder(root);
		//预期输出顺序rootValue a b c d e f g
		
//		root.layerOrder(root);
//		root.inOrderByStack(root);
//		root.lrdOrder(root);
//		String output =
//				root.postOrderByStack(root);
		String output =
					root.inOrderByStack(root);
		System.out.println(output);
		
		System.out.println("树的深度是:" + CustomTreeNode.getTreeDepth(root));
		
		System.out.println(root.layderOrderByQueue(root));
	}
	
	
}
