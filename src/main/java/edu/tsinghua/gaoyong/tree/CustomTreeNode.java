package edu.tsinghua.gaoyong.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 对树的一般节点的模拟，所有业务数据都抽象存储在value这个字符串当中ß
 * @author gaoyong
 *
 */
public class CustomTreeNode {
	
	//左子树
	private CustomTreeNode leftNode;
	
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
	
	public void layerOrder(CustomTreeNode root){
		List<CustomTreeNode> stack = new ArrayList<>();
		CustomTreeNode leftNode = root.getLeftNode();
		CustomTreeNode rightNode = root.getRightNode();
		
//		while(stack){
//			
//		}
		
	}
	
	
	
	
	public static void main(String[] args){
		CustomTreeNode root = new CustomTreeNode("rootValue");
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
		
		root.inorder(root);
		//预期输出顺序rootValue a b c d e f g
		
	}
	
	
}
