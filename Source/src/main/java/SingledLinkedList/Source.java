//// Có head và tail
//// Hàm thêm vào cuối
//void addLast(String xPlace, int xDepth, int xType) {
//        //You should write here appropriate statements to complete this function.
//        Node newNode = new Node(new Box(xPlace, xDepth, xType));
//        if (xPlace.charAt(0) == 'B') {
//            return;
//        }
//        if (head == null) {
//            head = tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//    }
//
//// Hàm insert viết theo kiểu index
//    void insert(int position, Box data) {
//        Node newNode = new Node(data);
//        if (position == 0) {
//            newNode.next = head;
//            head = newNode;
//            if (tail == null) {
//                tail = newNode;
//            }
//        } else {
//            Node temp = head;
//            // dừng ở phái trước index, vị trí cần insert
//            for (int i = 0; i < Math.abs(position - 1) && temp != null; i++) {
//                temp = temp.next;
//            }
//            if (temp != null) {
//                newNode.next = temp.next;
//                temp.next = newNode;
//                if (newNode.next == null) {
//                    tail = newNode;
//                }
//            }
//        }
//    }
//        
//        
//// Cái này là đi tìm một thg lớn nhất, nhỏ nhất
//// 1. Tìm ra cái depth lớn thứ nhất trong cái linkedlist hiện tại
//    int findMaxDepth(){
//        Node temp = head;
//        int maxDepth = Interger.MinValue;
//        
//        while(temp!=null){
//            if(temp.info.depth > maxDepth){
//                maxDepth = temp.info.depth;
//            }
//            temp = temp.next;
//        }
//        return maxDepth;
//    }
//        
//// 1. Tìm ra cái depth nhỏ thứ nhất trong cái linkedlist hiện tại
//    int findMinDepth(){
//        Node temp = head;
//        int minDepth = Interger.MaxValue;
//        
//        while(temp!=null){
//            if(temp.info.depth < minDepth){
//                minDepth = temp.info.depth;
//            }
//            temp = temp.next;
//        }
//        return minDepth;
//    }
//    
//    // 2. Đi tìm node đầu tiên có depth lớn nhất để thay đổi
//    void changeNode(){
//        Node temp = head;
//        int maxDepth = findMaxDepth();
//        while(temp!=null){
//            if(temp.info.depth == maxDepth){
//                temp.info.place = "XX";
//                return;
//            }
//            temp = temp.next;
//        }
//    }
//
// // 3. Đi tìm node thứ n có depth lớn nhát để thay đổi, muốn lần gặp thứ mấy thì lấy cái đó trừ 1
// // n-1
//    void changeSecondNode(){
//        Node temp = head;
//        int maxDepth = findMaxDepth();
//        int count = 0;
//        while(temp!=null){
//            if(temp.info.depth == maxDepth){
//                if(count == 1){
//                    temp.info.place = "XX";
//                    return;
//                }else{
//                    count++;
//                }
//            }
//            temp = temp.next;
//        }
//    }
//
//        
//        // Hoán đổi vị trí trong khoảng mong  muốn,
//void sort(int indexBegin, int indexEnd, boolean ascending){
//        // kiểm tra xem list này có bao nhiêu node
//        int count = 0;
//        Node temp = head;
//        while(temp!=null){
//            count++;
//            temp = temp.next;
//        }
//        // kiểm tra xem có đúng index không
//        if(indexBegin < 0 || indexEnd >= count || indexBegin > indexEnd){
//            return;
//        }
//        // Bubble sort
//        int length = indexEnd - indexBegin + 1;
//        for (int i = 0; i < length - 1; i++) {
//            Node prev = null;
//            Node current = head;
//            int index = 0;
//            // bởi vì không không yêu cầu bắt đầu từ head, nên phải dò đến vị trí yêu cầu
//            
//            while(index < indexBegin){
//                prev = current;
//                current = current.next;
//                index++;
//            }
//            // đây là đã trong khoảng cần sắp xếp
//            Node inner = current;
//            for (int j = 0; j < length - 1 - i; j++) {
//               if(inner != null && inner.next !=null){
//                   boolean swap = (ascending == true)
//                           ?(inner.info.depth >inner.next.info.depth)    001
//                           :(inner.info.depth <inner.next.info.depth);
//                   if(swap){//  điều kiện của if không phải là true false, nó là sắp tăng hoặc giảm
//                       // hoán đổi
//                       Box tmp = inner.info;                              022 
//                       inner.info = inner.next.info;
//                       inner.next.info = tmp;
//                   }
//               }
//                inner = inner.next;
//            }
//        }
//    }


// xóa nốt đầu tiên thỏa yêu cầu
//Node deleteFirstFragile() {
//        Node result = null;
//        //You should write here appropriate statements to complete this function.
//        //----------------------------------------------------------------------
//        Node prev = null;
//        Node temp = head;
//        while(temp!=null){
//            if(temp.info.getFragile() == 1){
//                result = temp;
//                if(temp == head){
//                   temp.next = head.next;
//                   head = temp;
//                   if(head == null){
//                       tail = null;
//                   }
//                }else{
//                    prev.next = temp.next;
//                    if(temp == tail){
//                        tail = prev;
//                    }
//                }temp.next = null;
//                break;
//            }
//            prev = temp;
//            temp = temp.next;
//    }
//        //----------------------------------------------------------------------
//        return result;
//    }

// xóa nốt cuối cùng thỏa yêu cầu 
//Node deleteLastFragile() {
//    Node result = null;
//    Node prev = null;
//    Node temp = head;
//
//    // Hai node dùng để ghi nhớ node fragile cuối cùng và node đứng trước nó
//    Node lastFragile = null;
//    Node lastFragilePrev = null;
//
//    while (temp != null) {
//        if (temp.info.getFragile() == 1) {
//            lastFragile = temp;
//            lastFragilePrev = prev;
//        }
//        prev = temp;
//        temp = temp.next;
//    }
//
//    if (lastFragile == null) return null;
//
//    result = lastFragile;
//
//    // Xóa lastFragile khỏi danh sách
//    if (lastFragile == head) {
//        head = head.next;
//        if (head == null) {
//            tail = null;
//        }
//    } else {
//        lastFragilePrev.next = lastFragile.next;
//        if (lastFragile == tail) {
//            tail = lastFragilePrev;
//        }
//    }
//
//    result.next = null;
//    return result;
//}

// xóa key
//ListNode removeById(String id) {
//            // Implement this function - Remove student with given ID from list
//            // --------------------------------------------------------
//            // YOUR CODE HERE
//            if(head == null) return null;
//            ListNode prev = null;
//            ListNode temp = head;
//            while (temp != null) {
//                if (temp.info.getId().equalsIgnoreCase(id)) {
//                    if (temp == head) {
//                        head = head.next;
//                        if (head == null) {
//                            tail = null;
//                        }
//                    }else{
//                        prev.next = temp.next;
//                        if(temp == tail){
//                            tail = prev;
//                        }
//                    }
//                    temp.next = null;
//                    return temp;
//                }
//                prev = temp;
//                temp = temp.next;
//            }
//            // --------------------------------------------------------
//            return null; // Change this return statement as needed
//        }
//
//ListNode removeSecondByMoney(double targetMoney) {
//    if (head == null) return null;
//
//    int count = 0;
//    ListNode prev = null;
//    ListNode temp = head;
//
//    while (temp != null) {
//        if (temp.info.getMoney() == targetMoney) {
//            count++;
//            if (count == 2) {
//                // Xóa node thứ 2 thỏa điều kiện
//                if (temp == head) {
//                    head = head.next;
//                    if (head == null) tail = null;
//                } else {
//                    prev.next = temp.next;
//                    if (temp == tail) tail = prev;
//                }
//                temp.next = null;
//                return temp; // Trả về chính node đã bị xóa
//            }
//        }
//        prev = temp;
//        temp = temp.next;
//    }
//
//    return null; // Không tìm thấy node thứ 2 thỏa điều kiện
//}


// trả về nút có giá trị lớn thứ hai
// Node getMaxStepNodeLessThan(int maxStep) {
//    Node temp = head;
//    Node target = null;
//    int maxBelow = Integer.MIN_VALUE;
//
//    while (temp != null) {
//        int step = temp.info.step;
//        if (step < maxStep && step > maxBelow) {
//            maxBelow = step;
//            target = temp;
//        }
//        temp = temp.next;
//    }
//
//    return target;
//}

// Trả về nói thứ hai nho hơn max
// Node getSecondNodeLessThanStep(int maxStep) {
//    Node current = head;
//    int count = 0;
//
//    while (current != null) {
//        if (current.info.step < maxStep) {
//            count++;
//            if (count == 2) return current;
//        }
//        current = current.next;
//    }
//
//    return null;
//}

// hàm tiềm cái gì đó, như là có tên là F
//Node findNode(String f){
//      Node temp = head;
//      while(temp!=null){
//          if(temp.info.desert.equalsIgnoreCase(f)) return temp;
//          temp = temp.next;
//      }
//      return null;
//  }

// đảo chiều ngược lại 
//void reverseAfter(Node p) {
//        if (p == null || p.next == null) {
//            return;
//        }
//
//        Node prev = null;
//        Node temp = p.next;
//        Node tailSegment = temp;
//
//        while (temp != null) {
//            Node next = temp.next;
//            temp.next = prev;
//            prev = temp;
//            temp = next;
//        }
//
//        p.next = prev;
//        tail = tailSegment;
//    }


// Xóa node đầu tiên thỏa yêu c
//     int findMaxWeight(){
//        Node temp = head;
//        int maxWeight = Integer.MIN_VALUE;
//        
//        while(temp!=null){
//            if(temp.info.weight > maxWeight){
//                maxWeight = temp.info.weight;
//            }
//            temp = temp.next;
//        }
//        return maxWeight;
//    }
//   void delete(int data){
//        Node prev = null;
//        Node temp = head;
//        while(temp!=null){
//            if(temp.info.weight == data){
//                if(temp == head){
//                   head = head.next;
//                   if(head == null){
//                       tail = null;
//                   }
//                }else{
//                    prev.next = temp.next;
//                    if(temp == tail){
//                        tail = prev;
//                    }
//                }temp.next = null;
//                return;
//           }
//           prev = temp;
//           temp = temp.next;
//    }
//   }


//  hàm swap  hai node với nhau
//void swapByPlace(String place1, String place2) {
//    if (place1 == null || place2 == null || place1.equalsIgnoreCase(place2)) return;
//
//    Node node1 = null, node2 = null;
//    Node temp = head;
//
//    while (temp != null) {
//        if (temp.info.place.equalsIgnoreCase(place1)) {
//            node1 = temp;
//        } else if (temp.info.place.equalsIgnoreCase(place2)) {
//            node2 = temp;
//        }
//        temp = temp.next;
//    }
//
//    if (node1 != null && node2 != null) {
//        Brick tmp = node1.info;
//        node1.info = node2.info;
//        node2.info = tmp;
//    }
//}

// Đếm  vị trí của node cần tìm
//int finNode(String place){
//        Node temp = head;
//        int count = 0;
//        while(temp!=null){
//            if(temp.info.place.equalsIgnoreCase(place)){
//                return count;
//            }
//            count++;
//            temp = temp.next;
//        }
//        return count;
//    }

// Swap vi tri 
//void swapAt(int i, int j) {
//    if (i == j) return; // Không cần đổi nếu cùng vị trí
//    if (i < 0 || j < 0 || i >= size() || j >= size()) return;
//
//    Node node1 = head, node2 = head;
//    int index1 = 0, index2 = 0;
//
//    // Tìm node tại vị trí i
//    while (index1 < i && node1 != null) {
//        node1 = node1.next;
//        index1++;
//    }
//
//    // Tìm node tại vị trí j
//    while (index2 < j && node2 != null) {
//        node2 = node2.next;
//        index2++;
//    }
//
//    // Hoán đổi info
//    if (node1 != null && node2 != null) {
//        Car temp = node1.info;
//        node1.info = node2.info;
//        node2.info = temp;
//    }
//}

//Xoa hang loat neu thoa dieu kien
//void deleteAllWeightLessThan(int threshold) {
//    Node current = head;
//    Node prev = null;
//
//    while (current != null) {
//        if (current.info.weight < threshold) {
//            if (current == head) {
//                head = head.next;
//                current = head;
//                if (head == null) tail = null;
//                continue;
//            } else {
//                prev.next = current.next;
//                if (current == tail) {
//                    tail = prev;
//                }
//                current = current.next;
//                continue;
//            }
//        }
//        prev = current;
//        current = current.next;
//    }
//}

//Xoa cai dau tien thoa
//void deleteFirstWeightLessThan(int threshold) {
//    if (head == null) return;
//
//    Node current = head;
//    Node prev = null;
//
//    while (current != null) {
//        if (current.info.weight < threshold) {
//            // Nếu là node đầu
//            if (current == head) {
//                head = head.next;
//                if (head == null) tail = null; // Danh sách trống sau khi xóa
//            }
//            // Nếu là node cuối
//            else if (current == tail) {
//                tail = prev;
//                tail.next = null;
//            }
//            // Nếu là node giữa
//            else {
//                prev.next = current.next;
//            }
//            break; // Dừng lại sau khi xóa node đầu tiên thỏa điều kiện
//        }
//
//        prev = current;
//        current = current.next;
//    }
//}

// Xoa cai cuoi cung thoa
//void deleteLastWeightLessThan(int threshold) {
//    Node current = head;
//    Node target = null;       // node cần xóa
//    Node prevTarget = null;   // node trước node cần xóa
//    Node prev = null;
//
//    // Bước 1: Tìm node cuối cùng thỏa điều kiện
//    while (current != null) {
//        if (current.info.weight < threshold) {
//            target = current;
//            prevTarget = prev;
//        }
//        prev = current;
//        current = current.next;
//    }
//
//    // Bước 2: Xóa node đó nếu tìm thấy
//    if (target == null) return; // Không có node nào thỏa điều kiện
//
//    // Nếu node cần xóa là head
//    if (target == head) {
//        head = head.next;
//        if (head == null) tail = null;
//    }
//    // Nếu node cần xóa là tail
//    else if (target == tail) {
//        tail = prevTarget;
//        tail.next = null;
//    }
//    // Nếu node cần xóa nằm ở giữa
//    else {
//        prevTarget.next = target.next;
//    }
//}

//gom ca hai truong ho
//void deleteWeightLessThan(int threshold, boolean deleteAll) {
//    Node current = head;
//    Node prev = null;
//
//    while (current != null) {
//        if (current.info.weight < threshold) {
//            if (current == head) {
//                head = head.next;
//                current = head;
//                if (head == null) tail = null;
//                if (!deleteAll) break;
//                continue;
//            } else {
//                prev.next = current.next;
//                if (current == tail) {
//                    tail = prev;
//                }
//                current = current.next;
//                if (!deleteAll) break;
//                continue;
//            }
//        }
//        prev = current;
//        current = current.next;
//    }
//}


// Ham dung de xoa mot thg thoa dieu kien lan thu N. Neu muon la thg thu hai thi de count = 1, 3 thi count == 2
//void deleteSecond(int data) {
//        Node prev = null;
//        Node temp = head;
//        int count = 0;
//        while (temp != null) {
//            if (temp.info.color < data) {
//                if (count == 1) {
//                    if (temp == head) {
//                        head = head.next;
//                        if (head == null) {
//                            tail = null;
//                        }
//                    } else {
//                        prev.next = temp.next;
//                        if (temp == tail) {
//                            tail = prev;
//                        }
//                    }
//                    temp.next = null;
//                    break;
//                }
//                count++;
//            }
//            prev = temp;
//            temp = temp.next;
//        }
//    }

// dem xuong cuoi
//void moveToEnd(int k) {
//    if (head == null || k < 0) return;
//
//    Node prev = null;
//    Node current = head;
//    int index = 0;
//
//    // Tìm node ở vị trí k
//    while (current != null && index < k) {
//        prev = current;
//        current = current.next;
//        index++;
//    }
//
//    // Nếu không tìm thấy hoặc đó là tail thì không cần làm gì
//    if (current == null || current == tail) return;
//
//    // Nếu là node đầu tiên
//    if (prev == null) {
//        head = current.next;
//    } else {
//        prev.next = current.next;
//    }
//
//    // Đưa current về cuối
//    current.next = null;
//    tail.next = current;
//    tail = current;
//}

// chuyen len dau
//void moveToFront(int k) {
//    if (head == null || k <= 0) return;
//
//    Node prev = null;
//    Node current = head;
//    int index = 0;
//
//    // Duyệt đến node ở vị trí k
//    while (current != null && index < k) {
//        prev = current;
//        current = current.next;
//        index++;
//    }
//
//    // Nếu không tồn tại hoặc đã ở đầu thì không làm gì
//    if (current == null || prev == null) return;
//
//    // Bỏ current khỏi vị trí hiện tại
//    prev.next = current.next;
//
//    // Đưa current lên đầu
//    current.next = head;
//    head = current;
//
//    // Nếu current chính là tail thì cập nhật lại tail
//    if (current == tail) {
//        tail = prev;
//    }
//}

// chuyen den mot vi tri bat ky
//void moveToPosition(int fromIndex, int toIndex) {
//    if (head == null || fromIndex == toIndex || fromIndex < 0 || toIndex < 0 || fromIndex >= size()) {
//        return;
//    }
//
//    // Tìm node ở vị trí fromIndex
//    Node prevFrom = null;
//    Node from = head;
//    int index = 0;
//    while (from != null && index < fromIndex) {
//        prevFrom = from;
//        from = from.next;
//        index++;
//    }
//
//    if (from == null) return; // Không tìm thấy node cần chuyển
//
//    // Gỡ node from khỏi danh sách
//    if (prevFrom == null) {
//        head = head.next; // from là head
//    } else {
//        prevFrom.next = from.next;
//    }
//
//    if (from == tail) {
//        tail = prevFrom;
//    }
//
//    // Chèn node vào vị trí toIndex
//    if (toIndex == 0) {
//        from.next = head;
//        head = from;
//        if (tail == null) tail = from;
//    } else {
//        Node prevTo = null;
//        Node to = head;
//        index = 0;
//        while (to != null && index < toIndex) {
//            prevTo = to;
//            to = to.next;
//            index++;
//        }
//        // Chèn vào giữa prevTo và to
//        prevTo.next = from;
//        from.next = to;
//
//        if (to == null) {
//            tail = from; // moved to the end
//        }
//    }
//}