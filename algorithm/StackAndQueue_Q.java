package algorithm;

import java.util.Stack;

public class StackAndQueue_Q {


    class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize){
            stackCapacity = stackSize;
            values = new int[stackSize * numberOfStacks];
            sizes = new int[numberOfStacks];
        }

        /** 스택에 값을 추가한다. */
        public void push(int stackNum, int value){
            /** 여유 공간이 있는지 검사한다. */
            if(isFull(stackNum)){
//                throw new FullStackException();
            }
            /** 스택 포인터를 증가시키고 가장 꼭대기 값을 갱신한다. */
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum){
            if(isEmpty(stackNum)){
                //
            }

            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }

        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }

        public int peek(int stackNum){
            return values[indexOfTop(stackNum)];
        }

        /** 스택이 꽉 차있으면 true 반환 */
        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        /** 스택의 꼭대기 값을 가리키는 인덱스를 반환한다. */
        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }



        /** 스택 Min push, pop이 구현된 stack에서 최솟값 반환하는 min 함수를 구현하라. */
        public class StackWithMin extends Stack {
            public void push(int value){
                int newMin = Math.min(value, min());
                super.push(new NodeWithMin(value, newMin));
            }

            public int min(){
                if(this.isEmpty()){
                    return Integer.MAX_VALUE;
                }
//                else {
//                    return peek().min;
//                }
                return 0;
            }
        }

        class NodeWithMin {
            public int value;
            public int min;
            public NodeWithMin(int v, int min){
                value = v;
                this.min = min;
            }

            public int peek(){
                return min;
            }
        }
    }


    public static class StackWithMin2 extends Stack {
        Stack s2;

        public StackWithMin2(){
            s2 = new Stack();
        }

        public void push(int value){
            if(value <= min()){
                s2.push(value);
            }
            super.push(value);
        }

        public Integer pop(){
            int value = (int) super.pop();
            if(value == min()){
                s2.pop();
            }
            return value;
        }

        public int min(){
            if(s2.isEmpty()){
                return Integer.MAX_VALUE;
            } else {
                int peek = (int) s2.peek();
                return peek;
            }
        }
    }


    /** 스택 2개로 하나의 큐 구현  331p */
    public class MyQueue {
        Stack stackNewest, stackOldest;

        public MyQueue() {
            stackNewest = new Stack();
            stackOldest = new Stack();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            /** 새로운 원소가 상단에 놓이도록 stackNewest에 원소를 삽입한다. */
            stackNewest.push(value);
        }

        /** stackNewest에서 stackOldest로 원소를 옮긴다. stackOldest 연산을 수행하기 위한 작업. */
        private void shiftStacks() {
            if(stackOldest.isEmpty()){
                while(!stackNewest.isEmpty()){
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek(){
            shiftStacks(); // stackOldest에 현재 원소들이 들어 있다.
            return stackOldest.peek(); // 가장 오래된 원소를 반환한다.
        }

        public T remove(){
            shiftStacks(); // stackOldest에 현재 원소들이 들어 있다.
            return stackOldest.pop(); // 가장 오래된 원소를 반환한다.
        }
    }

    public static void main(String[] args) {
        System.out.println("start ==>");
        StackWithMin2 stackWithMin2 = new StackWithMin2();
        stackWithMin2.push(2);
        stackWithMin2.push(4);
        stackWithMin2.push(1);
        stackWithMin2.pop();
        stackWithMin2.pop();
        stackWithMin2.pop();

    }
}
