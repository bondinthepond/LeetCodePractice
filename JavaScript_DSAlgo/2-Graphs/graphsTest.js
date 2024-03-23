import { Graph } from "./graphs";

let graph = new Graph();
graph.addVetex(5);
graph.addVetex(5);
graph.addVetex(15);
graph.addVetex(25);
graph.addVetex(35);
graph.addVetex(45);

graph.addEdge(5, 25);
graph.addEdge(5, 35);
graph.addEdge(35, 15);
graph.addEdge(5, 15);
graph.addEdge(35, 25);

graph.removeEdge(5, 15);
graph.removeEdge(35, 15);

console.log(graph);
