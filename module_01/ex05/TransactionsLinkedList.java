package ex05;
import java.util.UUID;
public class TransactionsLinkedList implements TransactionsList{
    Node head;
    int size;

    public TransactionsLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void clear(){
        this.head = null;
        this.size = 0;
    }

    public void AddTransaction(Transaction transaction){
        Node newNode = new Node(transaction);
        this.size++;
        if (this.head == null){
            this.head = newNode;
            return ;
        }
        newNode.next = this.head;
        this.head = newNode;
    }

    public Transaction getTransactionById(UUID transactionId){
        Node tmp = this.head;
        while(tmp != null){
            if (transactionId.equals(tmp.value.getId()))
                return tmp.value;
            tmp = tmp.next;
        }
        return null;
    }

    public void RemoveTransaction(UUID id) throws TransactionNotFoundException{
        Node tmp = this.head;
        Node prev = null;
        boolean isDeleted = false;
        while(tmp != null){
            if (id.equals(tmp.value.getId())){
                if (prev == null)
                    this.head = tmp.next;
                else
                    prev.next = tmp.next;
                isDeleted = true;
                break ;
            }
            prev = tmp;
            tmp = tmp.next;
        }
        if (isDeleted)
            this.size--;
        else
            throw new TransactionNotFoundException("no such transaction with this id: " + id);
    }


    public Transaction[] toArray(){
        Transaction[] array = new Transaction[this.size];
        int index = 0;
        Node tmp = this.head;
        while(tmp != null){
            array[index] = tmp.value;
            tmp = tmp.next;
            index++;
        }
        return array;
    }

    public int size(){
        return this.size;
    }
}