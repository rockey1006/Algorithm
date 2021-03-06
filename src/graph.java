public class graph {
final int MAX_VERTEX=10;//最多20个顶点
Vertex[]vertex;//顶点数组
int[][]ajacency;//邻接矩阵
int numofVertex;//当前图中顶点的数量
public graph() {//构造函数
	numofVertex=0;
	vertex=new Vertex[MAX_VERTEX];
	ajacency=new int[MAX_VERTEX][MAX_VERTEX];
	for(int i=0;i<MAX_VERTEX;i++) {
		for(int j=0;j<MAX_VERTEX;j++) {
			ajacency[i][j]=0;
		}
	}
}
public void addvertex(char v) {
	vertex[numofVertex++]=new Vertex(v);
}
public void addEdge1(int start,int end) {//
	ajacency[start][end]=1;
	ajacency[end][start]=1;
}
public void addEdge2(int start,int end) {//
	ajacency[start][end]=-1;
}
public void showvertex(int index) {
	System.out.println(vertex[index].lable);
}
public void showMatrix(){
for(int i=0;i<numofVertex;i++) {
	for(int j=0;j<numofVertex;j++) {
		System.out.print(ajacency[i][j]+" ");
	}
	System.out.println();
}
}
public int getUnvisitedVertex(int index) {//找到某一点附近未访问过的顶点
	for(int i=0;i<numofVertex;i++) {
		if(ajacency[index][i]==1&&vertex[i].wasvisited==false) {
			return i;	
		}
	}
	return-1;
}
public void BFS() {//广度遍历
	vertex[0].wasvisited=true;//访问V0
	showvertex(0);//打印V0
	arrayQueue a=new arrayQueue();//新建队列
	a.enqueue(0);//把访问过的V0放进队列
	int v2;
	while(a.isEmpty()==false) {
		int v1=a.dequeue();//哪一个顶点出来，就访问哪一个顶点所有的连接点判断是否被访问过
		while((v2=getUnvisitedVertex(v1))!=-1) {//找到所有V1没有访问过的顶点标记访问过
			vertex[v2].wasvisited=true;
			showvertex(v2);
			a.enqueue(v2);//加到队列
		}
	}
	for(int i=0;i<numofVertex;i++) {
		vertex[i].wasvisited=false;//遍历完后重设访问标记
	}
}
public void DFS() {//深度遍历
	vertex[0].wasvisited=true;
	showvertex(0);
	arrayStack a=new arrayStack();
	a.push(0);
	while(a.isEmpty()==false) {//找到栈顶附近是否有未访问过的顶点
		int v1=getUnvisitedVertex(a.peek());
		if(v1==-1) {//如果没有，就弹出到上一层
			a.pop();
		}
		else {//如果找到
			vertex[v1].wasvisited=true;//标记已访问
			showvertex(v1);
			a.push(v1);//入栈进入下一层
		}
	}
	for(int i=0;i<numofVertex;i++) {
		vertex[i].wasvisited=false;//遍历完后重设访问标记
}
}
class Vertex{
	char lable;
	boolean wasvisited;
	public Vertex(char v) {
		this.lable=v;
		this.wasvisited=false;
	}
}
class arrayQueue {
	int first;
	int last;
	int[]aq;
	final int SIZE=10;
	public arrayQueue() {
		first=0;
		last=-1;
		aq=new int[SIZE];	
	}
	public void enqueue(int data) {
		if(last==SIZE-1) {
			last=-1;
		}
		aq[++last]=data;
	}
	public int dequeue() {
		if(first==SIZE) {
			first=0;
		}
		return aq[first++];
	}
public boolean isEmpty() {
	return last+1==first||first+SIZE-1==last;//不是last=-1||first=0
}
}
public class arrayStack {
int top;
int[]stack;
final int SIZE=10;
public arrayStack() {
	stack=new int[SIZE];
	top=-1;
}
public void push(int data) {
	stack[++top]=data;
}
public int pop() {
	return stack[top--];
}
public int peek() {
	return stack[top];
}
public boolean isEmpty() {
	return top==-1;
}
}
	public static void main(String[] args) {
		graph a=new graph();
		a.addvertex('A');
		a.addvertex('B');
		a.addvertex('C');
		a.addvertex('D');
		a.addvertex('E');
		a.addvertex('F');
		a.addvertex('G');
		a.addvertex('H');
		a.addvertex('I');		
		a.addEdge1(0, 1);
		a.addEdge1(0, 5);
		a.addEdge1(1, 2);
		a.addEdge1(1, 8);
		a.addEdge1(1, 0);
		a.addEdge1(1, 6);
		a.addEdge1(2, 1);
		a.addEdge1(2, 8);
		a.addEdge1(2, 3);//ABCDEFGHI
		                 //012345678
		a.addEdge1(3, 8);
		a.addEdge1(3, 2);
		a.addEdge1(3, 6);
		a.addEdge1(3, 4);
		a.addEdge1(3, 7);
		a.addEdge1(4, 5);
		a.addEdge1(4, 3);
		a.addEdge1(4, 7);
		a.addEdge1(5, 0);
		a.addEdge1(5, 6);
		a.addEdge1(5, 4);
		a.addEdge1(6, 5);
		a.addEdge1(6, 3);
		a.addEdge1(6, 1);
		a.addEdge1(6, 7);
		a.addEdge1(7, 6);
		a.addEdge1(7, 4);
		a.addEdge1(7, 3);
		a.addEdge1(8, 1);
		a.addEdge1(8, 2);
		a.addEdge1(8, 3);
		//a.showvertex(1);
		//a.showMatrix();
		//a.BFS();
		a.DFS();
	}
}
