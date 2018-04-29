package com.muric.checkers;

/*
    N is 1-30
    Checkers Board is N x N
    Dot . , X and O
    Pawns only could take other pawns forward.
    Find maximum pawns that could be taken by O
 */
public class Checkers {
    private char[][] board;
    int maxWeight = 0;
    int boardSize = 0;

    private class Node {
        private int weight;
        private int horizontal;
        private int vertical;
        private Node upLeft;
        private Node upRight;

        public Node(int weight, int horizontal, int vertical){
            this.weight = weight;
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    public int solution(String[] B) {
        Node root = null;

        populate(B);
        for(int ii=0; ii<boardSize; ii++){
            if(B[ii].contains("O")){
                int jj = B[ii].indexOf('O');
                root = new Node(0, jj, ii);
                break;
            }
        }

        calculateMoves(root);

        return maxWeight;
    }

    private void calculateMoves(Node node){
        if(node.vertical > 1){
            // Up and left
            if(node.horizontal > 1 && board[node.vertical-1][node.horizontal-1] == 'X' && board[node.vertical-2][node.horizontal-2] == '.'){
                node.upLeft = new Node(node.weight + 1, node.horizontal-2, node.vertical-2);
                if (maxWeight < node.upLeft.weight){
                    maxWeight = node.upLeft.weight;
                }
                calculateMoves(node.upLeft);
            }

            // Up and right
            if(node.horizontal < boardSize - 2 && board[node.vertical-1][node.horizontal+1] == 'X' && board[node.vertical-2][node.horizontal+2] == '.'){
                node.upRight = new Node(node.weight + 1, node.horizontal+2, node.vertical-2);
                if (maxWeight < node.upRight.weight){
                    maxWeight = node.upRight.weight;
                }
                calculateMoves(node.upRight);
            }
        }
    }

    private void populate(String[] B){
        boardSize = B.length;
        maxWeight = 0;
        board = new char[boardSize][boardSize];
        for(int ii=0; ii<boardSize; ii++){
            board [ii] = B[ii].toCharArray();
        }

//        printBoard();
    }

    private void printBoard(){
        for (int vv=0; vv<board.length; vv++){
            System.out.printf("\n%2d - ", vv);
            for (int hh=0; hh<board.length;hh++){
                System.out.print(board[vv][hh]);
            }
        }
    }
}
