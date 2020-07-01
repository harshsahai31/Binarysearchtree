package Binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class Binarysearchtee {
	private Treenode root;

	public Binarysearchtee(){
		root=null;
	}

	private static class Treenode{
		private int data;
		private Treenode left;
		private Treenode right;

		public Treenode(int data){
			this.data=data;
			left=null;
			right= null;
		}

	}  public void createbinarytree(){
		Treenode first = new Treenode(5);
		Treenode second = new Treenode(4);
		Treenode third = new Treenode(6);
		Treenode four = new Treenode(3);
		Treenode five = new Treenode(7);
		Treenode six = new Treenode(2);

		root=first;
		first.left=second;
		first.right=third;
		second.left=four;
		second.right= five;
		third.left=six;

	}
	public void preordertraverse(Treenode root){
		if(root==null){
			return ;
		}
		System.out.println(root.data);
		preordertraverse(root.left);
		preordertraverse(root.right);
	} public void levelordertraverse(){
		if(root==null){
			return;
		} Queue<Treenode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()){
			Treenode temp = q.poll();
			System.out.println(temp.data);
			if(temp.left!=null){
				q.offer(temp.left);
			} if(temp.right!=null){
				q.offer(temp.right);
			}
		}
	} public static boolean binarysearch(Treenode root,int value){
		while(root!=null){
			if(value<root.data){
				root=root.left;
			} else if(value>root.data){
				root= root.right;
			} else{
				return true;
			}
		} return false;
	}
	void insert(int value){
		root = insertrec(root,value);
	}
    Treenode insertrec(Treenode root,int value){
		if(root==null){
			root = new Treenode(value);
			return root;
		} else if(value<root.data){
			root.left = insertrec(root.left,value);
		} else if (value > root.data)
			root.right= insertrec(root.right,value);

			return root;

    } void inorder(){
		inorderrec(root);
	}  void inorderrec(Treenode root){
		if(root==null){
			return;
		}
		inorderrec(root.left);
		System.out.println(root.data);
		inorderrec(root.right);
	}  void delete(int value){
		root= deleterec(root,value);
	}
    Treenode deleterec(Treenode root,int value){
		if(root == null){
			return root;
		} else if(value<root.data){
			root.left = deleterec(root.left,value);
		}else if (value>root.data){
			root.right= deleterec(root.right,value);
		} else{

		}
    }


	public static void main(String[] args) {
		Binarysearchtee bst= new Binarysearchtee();
		//bst.createbinarytree();
		//bst.preordertraverse(bst.root);

		bst.insert(50);
		bst.insert(30);
		bst.insert(20);
		bst.insert(40);
		bst.insert(70);
		bst.insert(60);
		bst.insert(80);
        bst.inorder();
	//	bst.preordertraverse(bst.root);
	//	bst.levelordertraverse();
	if(binarysearch(bst.root,9)){
		System.out.println("yes");
	}
	else{
		System.out.println("no");
	}
	}
}
