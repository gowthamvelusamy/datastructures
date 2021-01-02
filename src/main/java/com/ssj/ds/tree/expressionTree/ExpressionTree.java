package com.ssj.ds.tree.expressionTree;


import com.ssj.ds.tree.Node;

import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ExpressionTree {

    static final List operators = Arrays.asList('+', '-', '*', '/');
    static final Map<Character, Integer> operatorPriority = new HashMap<>();

    {
        operatorPriority.put('+', 1);
        operatorPriority.put('-', 1);
        operatorPriority.put('/', 2);
        operatorPriority.put('*', 2);
    }

    public Node expressionTreeBuilder(final String expression) {
        Node<Character> current = null;
        final Stack<Character> operatorStack = new Stack<>();
        final Stack<Node> nodeStack = new Stack<>();
        //Iterate through every item of input expression and process one at a time
        for (final char currentItem : expression.toCharArray()) {
            if(currentItem == '('){
              operatorStack.push(currentItem);
            }
            else if(currentItem == ')'){
                while( operatorStack.peek() != '('){
                    current = new Node<>(operatorStack.pop());
                    current.setRight(nodeStack.pop());
                    current.setLeft(nodeStack.pop());
                    nodeStack.push(current);
                }
                //Clean up the paranthesis set
                operatorStack.pop();
            }else {
                if(operators.contains(currentItem)){
                    while( !operatorStack.isEmpty()
                            && operatorStack.peek() != '('
                            && operatorPriority.get(currentItem) <= operatorPriority.get(operatorStack.peek())){
                        current = new Node<>(operatorStack.pop());
                        current.setRight(nodeStack.pop());
                        current.setLeft(nodeStack.pop());
                        nodeStack.push(current);
                    }
                    operatorStack.push(currentItem);
                }else{
                    nodeStack.push(new Node<>(currentItem));
                }
            }
        }
        return current;
    }

}
