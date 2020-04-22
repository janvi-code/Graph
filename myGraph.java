import java.util.*;
import java.lang.*;
class Main
{ 
	int v;
	public int edge;
	public int vertex;
	public int marked[];
	Queue<Integer> queue=new LinkedList<>();
	Stack<Integer> stack=new Stack<>();
	private LinkedList<Integer> adj[];
   Main(int v)
   {
	   this.v=v;
	   marked=new int[v];
	     adj = new LinkedList[v]; 
	        for (int i=0; i<v; i++) 
	            adj[i] = new LinkedList();
   }
   public void addEdge(int v,int w)
   {
	   int flag=0;
	   if(v!=w)
	   {
		  for(int i=0;i<adj[v].size();i++)
			   if(adj[v].get(i)==w)
			   {
				   flag=1;
				   break;
			   }
		  if(flag==0)
		  {
			  edge++;
			  adj[v].add(w); 
			   adj[w].add(v);
		  }
	   }
	  
   }
   public void print()
   {
	   for(int i=0;i<adj.length;i++)
	   { System.out.println("Adjacency list of " + i); 
		   for(int j=0;j<adj[i].size();j++)
		   {
			   System.out.print(adj[i].get(j)+" ");
		   }
		   System.out.println();
	   }
   }
   public void cM()
   {
	   for(int i=0;i<v;i++)
		   marked[i]=0;
   }
   public int connectedComponenets()
   {
	   int count=0;
	   for(int i=0;i<v;i++)
		   if(marked[i]==0) 
		   {
			bfsConnected(i);
		   count++;
		   }
	   return count;
   }
   public void bfsConnected(int s)
   {
	   marked[s]=1;
	   queue.add(s);
	   while(!queue.isEmpty())
	   {
		   int element=queue.poll();
		   for(int i=0;i<adj[element].size();i++)
		   { 
			   if(marked[adj[element].get(i)]==1)
			      continue;
			   else
			   {
				   marked[adj[element].get(i)]=1;
				 queue.add(adj[element].get(i));
			   }
		   }
	   }
	 
   }
   public void bfs(int s)
   {
	   marked[s]=1;
	   queue.add(s);
	   while(!queue.isEmpty())
	   {
		   int element=queue.poll();
		   System.out.println(element);
		   for(int i=0;i<adj[element].size();i++)
		   { 
			   if(marked[adj[element].get(i)]==1)
			      continue;
			   else
			   {
				   marked[adj[element].get(i)]=1;
				 queue.add(adj[element].get(i));
			   }
		   }
	   }
	 cM();
   }
   public int Edges()
   {
	   return edge;
   }
   public int Vertex()
   {
	   return v;
   }
   public void dfs(int s)
   {
	  stack.push(s);
	  while(!stack.isEmpty())
	  {
		  int element=stack.pop();
		  if(marked[element]==0)
		  {
			  marked[element]=1;
			  System.out.println(element);
		  }
		  for(int i=0;i<adj[element].size();i++)
		  {
			  if(marked[adj[element].get(i)]==0) {
				  
				  stack.push(adj[element].get(i));}
		  }
	  }
	  cM();
   }
}
public class myGraph
{
	public static void main(String args[])
	{
		int V = 9; 
		  
        Main g = new Main(V); 
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(1, 4);   
        g.dfs(0);
        System.out.println("cc="+g.connectedComponenets());
        System.out.println("edges="+g.Edges());
 
	}
}