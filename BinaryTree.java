package robsontraversal;  
 import java.util.Scanner;  
 public class BinaryTree {  
   ListNode root = null;  
   ListNode p = root;  
   int i = 1;  
   int yu = 1;  
   Stack stack = new Stack();  
   Stack stack1 = new Stack();  
   ListNode Stack = null;  
   ListNode top = null;  
   ListNode avail = null;  
   ListNode pred = null;  
   ListNode next = null;  
   ListNode predPred = null;  
   boolean leftSubTreeComplete = false;  
   boolean rightSubTreeComplete = false;  
   boolean rightLegOnly = false;  
   boolean noLeftTree = false;  
   boolean entireTreeLeftLegOnly = false;  
   boolean entireTreeRightLegOnly = false;  
   boolean leftLegDoneNoRightLeg = false;  
   boolean hitTopRootOnce = false;  
 public void robsonTraversal()  
   {  
     p = root;  
     if (root==null) {System.out.println(“null tree”);return;}  
     if (p.lt!=null&&p.rt==null) entireTreeLeftLegOnly = true;  
     if (p.lt==null&&p.rt!=null) entireTreeRightLegOnly = true;  
     while (!(p==root&&top==root&&root.rt!=null)){  
       while (p!=null && !leftSubTreeComplete) //traverses left subtree until p hits null  
       {  
         visit(p);  
         if(p.lt == null && p.rt != null) break;  
         next = p.lt;  
         if (p.lt==null&&p.rt==null)  
         {  
           avail = p;  
         }  
         p.lt = pred;  
         pred = p;  
         p = next;  
       }  
       //if node has null left subtree and nonnull right subtree  
      if (p != null && p.lt==null&&p.rt!=null)  
       {  
         rightLegOnly =true;  
       }  
       if (pred!=top && pred.lt!=null&&!rightLegOnly){ //restores left leg of node  
       next = p;  
         p = pred;  
       pred = pred.lt;  
       p.lt=next;  
       }  
       if (!rightLegOnly && pred!=null){  
       while (leftLegDoneNoRightLeg||pred==top || (pred!=root&&pred.lt==null)  
           ||(entireTreeRightLegOnly&&pred.lt==null)) //finish upward traversal of right subtree  
       {  
         if (pred==top) {  
         predPred = pred.rt;  
         pred.rt = p;  
         p = pred;  
         pred = predPred;  
         if((p==root&&top==root&&root.rt!=null)) return; //finished traversing entire tree  
         if (entireTreeRightLegOnly)  
         {  
           if (p==root)return;  
         }  
         //pops Stack  
         if (Stack!=null){  
         ListNode temporary = Stack;  
         top = Stack.rt;  
         Stack.rt=null;  
         Stack = Stack.lt;  
         temporary.lt=null;  
         }  
         else top = null;leftLegDoneNoRightLeg=false;  
         if (pred.lt!=null || ((pred==root)&&pred.lt==null)){//modified  
            leftSubTreeComplete = false;  
          }  
         }  
         else{ predPred = pred.rt;  
         pred.rt = p;  
         p = pred;  
         pred = predPred;  
         if((p==root&&top==root&&root.rt!=null)) return; //finished traversing entire tree  
         if (entireTreeRightLegOnly)  
         {  
           if (p==root)return;  
         }  
          leftLegDoneNoRightLeg=false;  
          if ((pred.lt!=null)|| ((pred==root)&&pred.lt==null)){ //modified  
            leftSubTreeComplete = false;  
          }  
         }  
         rightSubTreeComplete = true;  
       }  
       }  
       if(!leftSubTreeComplete) //finish upward traversal of left subtree  
       {  
         //if p has no right subtree after upward restoration, than p’s left leg is restored  
         if (p.rt==null)  
           {  
           predPred = pred.lt;  
           pred.lt =p;  
           p = pred;  
           pred = predPred;  
           }  
         else if (rightSubTreeComplete)  
           {  
           predPred = pred.lt;  
           pred.lt =p;  
           p = pred;  
           pred = predPred;rightSubTreeComplete = false;  
           //added. After finishing traversal of left  
           //subtree, restores right leg of pred root top, if p has no right subtree  
           if (pred==root&&pred.rt==null&&pred==top&&p.rt==null)  
           {  
             predPred = pred.rt;  
             pred.rt = p;  
             p = pred;  
             pred = predPred;  
             if((p==root&&top==root&&root.rt!=null)) return; //finished traversing entire tree  
             if (entireTreeRightLegOnly)  
             {  
               if (p==root)return;  
             }  
           }  
           //added  
           }  
         if (entireTreeLeftLegOnly&&p==root) return;  
         leftSubTreeComplete = true;  
       }  
        if (leftSubTreeComplete) //initiate traversal of right subtree  
       {  
          if (p.rt==null && (pred==root||pred.lt!=null)   &&pred!=top)//added  
         {  
           predPred = pred.lt;  
           pred.lt =p;  
           p = pred;  
           pred = predPred;  
           }  
          if (entireTreeLeftLegOnly&&p==root) return;  
         if (top!=null && p.lt!=null&& p.rt!=null)  
         {  
         avail.lt = Stack;  
         Stack = avail;  
         Stack.rt = top;  
         top = p;  
         }  
         else if(p.lt!=null && p.rt!=null)  
         {top = p;}  
         if (p.rt!=null){  
         next = p.rt;  
        p.rt = pred;  
         pred = p;  
         p = next;leftSubTreeComplete = false;}  
       }  
       rightLegOnly=false;  
    }  
   }  
   public void reset1()  
   {  
    p = root;  
    Stack = null;  
    top = null;  
    avail = null;  
    pred = null;  
    next = null;  
    predPred = null;  
    leftSubTreeComplete = false;  
    rightSubTreeComplete = false;  
    rightLegOnly = false;  
    noLeftTree = false;  
    entireTreeLeftLegOnly = false;  
   entireTreeRightLegOnly = false;  
   leftLegDoneNoRightLeg = false;  
    hitTopRootOnce = false;  
   }  
   public void createTree()  
   {  
     Scanner in = new Scanner(System.in);  
     String nullOrNonNull = in.next();  
     if (nullOrNonNull.equals(“1”))  
     {  
       p = new ListNode(1);  
       root=p;  
       int yu = 1;  
       preorder1();  
     }  
     else  
     {  
       p=null;  
     }  
     p = root;  
   }  
   public void preorder1()  
   {  
     p = root; ListNode rtptr;ListNode q;  
     while ((p!=null)||stack1.n!=0)  
     {  
       if (p!=null)  
       {  visit1(p); p.info = yu; yu++;  
       if (p.lt!=null)stack1.push(p);  
         if (p.lt!=null) p = p.lt; else p=p.rt;}  
       else{  
         do{  
           q = stack1.pop();  
            if (stack1.n!=0)  
            {rtptr = q.rt; stack1.n–;}  
           else rtptr = null;  
         }while (stack1.n!=0&&q==rtptr);  
         p = rtptr;  
       }  
     }  
   }  
   public void preorder()  
   {  
     p = root; ListNode rtptr;ListNode q;  
     while ((p!=null)||stack1.n!=0)  
     {  
       if (p!=null)  
       {  visit(p);  
       if (p.lt!=null)stack1.push(p);  
         if (p.lt!=null) p = p.lt; else p=p.rt;}  
       else{  
         do{  
           q = stack1.pop();  
            if (stack1.n!=0)  
            {rtptr = q.rt; stack1.n–;}  
           else rtptr = null;  
         }while (stack1.n!=0&&q==rtptr);  
         p = rtptr;  
       }  
     }  
   }  
   public void visit1(ListNode p)  
   {  
         Scanner in2 = new Scanner(System.in);  
         String input = in2.nextLine();  
         String[] parts = input.split(” “);  
         int left = Integer.parseInt(parts [0]); //store predessor  
         int right = Integer.parseInt(parts [1]); //store successor  
         if (left==1&&right==1)  
         {  
           p.lt=new ListNode(yu);  
           p.rt=new ListNode(yu);  
         }  
         else if (left==1&&right==0)  
         {  
           p.lt=new ListNode(yu);  
         }  
         else if(right==1&&left==0)  
         {  
           p.rt = new ListNode(yu);  
         }  
         else  
         {  
         }  
   }  
   public void visit(ListNode p)  
   {  
   // System.out.print(” ” + p.info);  
    System.out.println(“Node Visited: ” + p.info);  
    if (p.lt!=null)System.out.print(“Node Left: “+p.lt.info);  
    if (p.rt!=null)System.out.print(” Node Right: “+p.rt.info);  
    System.out.println();  
     System.out.println(“———————————“);  
     System.out.println(“Top Information”);  
     if(top!=null){  
     System.out.println(“Top: “+ top.info);  
     if(top.lt!=null){System.out.print(“Top left: “+top.lt.info); }  
     if(top.rt!=null)System.out.print(” Top right: “+top.rt.info);  
     System.out.println();  
     }  
     System.out.println(“———————————“);  
     System.out.println(“Stack Information”);  
     if (Stack!=null){  
       ListNode temporary = Stack;  
     while (Stack!=null){  
     System.out.println(“Stack: “+ Stack.info);  
     if(Stack.lt!=null)System.out.print(“Stack left: ” + Stack.lt.info);  
     if(Stack.rt!=null)System.out.print(” Stack right ” + Stack.rt.info);  
     System.out.println();  
     Stack = Stack.lt;  
     }  
     Stack = temporary;  
     }  
     System.out.println(“———————————“);  
     System.out.println(“Path From Pred to Root”);  
     ListNode temporary = Stack;  
     if (pred!=null){  
         ListNode x = pred;  
         while (x!=root){  
             System.out.println(“Node Path: “+x.info);  
             if (x.lt!=null)System.out.print(“Node Path left: ” + x.lt.info);  
             if (x.rt!=null)System.out.print(” Node Path right: ” + x.rt.info);  
             System.out.println();  
              if (x==top||(x.lt==null&&x.rt!=null)||(Stack!=null&&x==Stack.rt))  
             {  
               if (Stack!=null&&x==Stack.rt)Stack = Stack.lt;  
               x = x.rt;  
             }  
             else if (x.lt!=null)  
             x = x.lt;  
             else if (x.rt!=null && x.lt==null)  
             {  
               x = x.rt;  
             }  
               }  
     }  
     Stack = temporary;  
     System.out.println();  
     System.out.println();  
     System.out.println();  
   }  
   public void initiliazeTree(int c)  
   {  
     if (c==1){  
     ListNode newNode = new ListNode(1);  
     root = newNode;  
     p = root;  
     i++;}  
     else  
     { root = null;  
         }  
   }  
   public void createNode(int left, int right)  
   {  
     if (root!=null)  
     {  
       if (left==1 && right==1){  
         if (p==null)  
        {  
         p =(stack.pop()).rt;  
        }  
       ListNode newNodeLeft = new ListNode(i); i++;  
       ListNode newNodeRight = new ListNode(i); i++;  
       p.lt = newNodeLeft;  
       p.rt = newNodeRight;  
       stack.push(p);  
       p=p.lt;  
       }  
       else if (left ==1 && right ==0)  
       {  
         if (p==null)  
        {  
         p =(stack.pop()).rt;  
        }  
       ListNode newNodeLeft = new ListNode (i); i++;  
       p.lt = newNodeLeft; stack.push(p);  
       p=p.lt;  
       }  
       else if (right ==1 && left ==0)  
       {  
        if (p==null)  
        {  
         p =(stack.pop()).rt;  
        }  
        ListNode newNodeRight = new ListNode (i); (i)++;  
        p.rt = newNodeRight; stack.push(p);  
        p=p.lt;  
       }  
       else  
       {  
        p =(stack.pop()).rt;  
        if (p==null)  
        {  
         p =(stack.pop()).rt;  
        }  
       }  
     }  
   }  
   public class Stack  
   {  
     int n=0;  
     ListNode top = new ListNode(0);  
     public void push(ListNode h)  
     {  
       if (top == null)  
       {  
         n++;  
         ListNode newPointer = new ListNode(0);  
         top = newPointer;  
         newPointer.rt = h;  
       }  
       else  
       {  
         n++;  
         ListNode newPointer = new ListNode(0);  
         newPointer.lt=top;  
         top = newPointer;  
         newPointer.rt = h;  
       }  
     }  
     public ListNode pop()  
     {  
       ListNode returnTop = top.rt;  
       top = top.lt;  
       return returnTop;  
     }  
   }  
   public class ListNode  
   {  
     int info;  
     ListNode lt;  
     ListNode rt;  
     public ListNode(int data)  
     {  
       this.info = data;  
       lt = null;  
       rt = null;  
     }  
     boolean isLeaf(){  
       return lt == null && rt == null;  
     }  
   }  
 } 