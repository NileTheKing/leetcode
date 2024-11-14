/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode pointer = head;
        ListNode fast = head;
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();

        
        //fast.next.next가 널값이면 pointer는 정확히 중간에 옴.
        while (fast != null && fast.next != null) {
            firstHalf.add(pointer.val);
            pointer = pointer.next;
            fast = fast.next.next;
        }
        
        //이제 반으로 나눈 것의 후반부를 값에 저장함
        while(pointer != null) {
            secondHalf.add(pointer.val);
            pointer = pointer.next;
        }

        //이제 어레이리스트를 순회하며 최댓값만 구하면 됨. easy

        //firstHalf의 크기와 secondHalf의 크기는 동일함
        int size = Math.min(firstHalf.size(), secondHalf.size());
        int max = 0; //constraints: 1 <= node.val <= 10^5
        for(int i = 0; i < size; i++) {
            max = Math.max(max, firstHalf.get(i) + secondHalf.get(size - 1 - i));
        }

        return max;
    }
}
/**
자 드가자
최댓값을 리턴하면 되는 문제.
int max를 선언 후 연결 리스트를 순회하면 됨.
그렇다면 포문으로 연결리스트를 순회하고 인떠르널뽀인떠르를 두개 선언해서
first, last를 쓰면 되게쎈.

q. first포인터는 head쓰면 되는데 last포인터는 어떻게 지정하지?
    1. 한 번 순회한 뒤 지정. -> 이거는 안됨. 왜냐하면 리스트를 거꾸로 연결하는 것도 해야되는데 시간 낭비.
    2. 그렇다면 리스트를 한 번 순회하면서 배열에다가 값을 저장해가지고 first 배열과 last배열 만들어서 더하며 되겠따. 이걸로 ㄱ
        2-1. 배열 두 개 만들 때 사이ㅏ즈를 몰라. 그니까 어레이리스트를 써야하나?
 */