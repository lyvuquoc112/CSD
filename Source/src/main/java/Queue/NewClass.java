// ham them vao
//void enQueue(int size, int price) {
//        if(size <= 0 || price <= 0) return;
//        Node newNode = new Node(new Room(size, price));
//        if(front == null){
//            front = rear = newNode;
//        }else{
//            rear.next = newNode;
//            rear = newNode;
//        }
//    }

// ham xuat ra
//    Room deQueue() {
//        Room tmp = new Room();
//        if(isEmpty()) return null;
//        tmp = front.info;
//        front = front.next;
//        if(front == null){
//            rear = null;
//        }
//        return tmp;
//    }