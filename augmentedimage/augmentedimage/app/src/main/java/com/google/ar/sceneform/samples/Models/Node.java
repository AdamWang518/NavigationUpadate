package com.google.ar.sceneform.samples.Models;

public class Node {
        public String question;
        public Node left;
        public Node right;
        //"Node objects have a question, and  left and right pointer to other Nodes"
        public Node(String question, Node left, Node right){
            this.question = question;
            this.left     = left;
            this.right    = right;
        }
        public Node(String question){
            this.question = question;
        }
        public Node(){};
}
