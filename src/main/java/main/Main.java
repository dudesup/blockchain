package main;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        for (int i = 0; i <10 ; i++) {
            blockchain.generate();
        }
        for (int i = 0; i <5 ; i++) {
            Block block = blockchain.getBlockchainList().get(i);
            System.out.println(block.toString() + "\nHash of the block: \n" + StringUtil.applySha256(block.getId()+block.getTimeStamp()+block.getHashOfPreviousBlock()) + "\n");
        }
    }
}
