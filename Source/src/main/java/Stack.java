//ham push 
// Node newNode = new Node(new Item(name, weight, length, fragile));
//        if(weight <= 0 || length <= 0){
//            return;
//        }
//        if(head == null){
//            head = newNode;
//        }else{
//            newNode.next = head;
//            head = newNode;
//        }


//ham peek
//public int peek() {
//        if (!isEmpty()) {
//            return top.info;
//        } else {
//            System.out.println("Stack is empty!");
//            return -1;
//        }
//    }

//ham pop
// function to return value of top element and remove top element in a stack
    // -1: return a default value if stack is empty
//    public int pop() {
//        if (!isEmpty()) {
//            int value = top.info; // lưu giữ giá trị của top
//            top = top.next; // dời top sang phần tử tiếp theo
//            return value; // trả về giá trị của top
//        } else {
//            System.out.println("Stack is empty!");
//            return -1;
//        }
//    }