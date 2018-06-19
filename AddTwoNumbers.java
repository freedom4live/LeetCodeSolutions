/*You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order and each of their nodes contain a single digit.
        Add the two numbers and return it as a linked list.You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isFinished = false;
        int buff = 0;
        ListNode currentFirst = l1;
        ListNode currentSecond = l2;
        ListNode currentResult = null;
        ListNode previousResult = null;
        ListNode result = null;
        int firstNumber = currentFirst.val;
        int secondNumber = currentSecond.val;
        while (!isFinished) {
            int summ = firstNumber + secondNumber + buff;
            buff = 0;
            int calculatedValue = 0;
            if (summ < 10) {
                calculatedValue = summ;
            } else {
                buff = ((int) (summ / 10));
                calculatedValue = summ % 10;
            }

            currentResult = new ListNode(calculatedValue);
            if (null != previousResult) {
                previousResult.next = currentResult;
            }
            if (null == result) {
                result = currentResult;
            }

            previousResult = currentResult;

            if (null == currentFirst.next && null == currentSecond.next) {
                isFinished = true;
            } else {
                if (null != currentFirst.next) {
                    currentFirst = currentFirst.next;
                    firstNumber = currentFirst.val;
                } else {
                    firstNumber = 0;
                }

                if (null != currentSecond.next) {
                    currentSecond = currentSecond.next;
                    secondNumber = currentSecond.val;
                } else {
                    secondNumber = 0;
                }
            }
        }

        if (buff != 0) {
            currentResult = new ListNode(buff);
            previousResult.next = currentResult;
        }

        return result;
    }
}
