package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Blockchain {
    private final List<Block> blockchainList = new ArrayList<>();

    public void generate(){
        long id = blockchainList.size()+1;
        long timeStamp = new Date().getTime();

        String hashOfPreviousBlock;
        if(blockchainList.size()==0){
            hashOfPreviousBlock="0";
        } else {
            Block previousBlock = blockchainList.get(blockchainList.size()-1);
            hashOfPreviousBlock = StringUtil.applySha256(previousBlock.getId()+previousBlock.getTimeStamp()+previousBlock.getHashOfPreviousBlock());
        }

        Block newBlock = new Block(id, timeStamp, hashOfPreviousBlock);
        blockchainList.add(newBlock);
        //System.out.println(blockchainList);
    }

    public boolean validate(){
        for (int i = 0; i <blockchainList.size()-1 ; i++) {
            String blockI = StringUtil.applySha256(blockchainList.get(i).getId()+blockchainList.get(i).getTimeStamp()+blockchainList.get(i).getHashOfPreviousBlock());
            for (int j = i+1; j <blockchainList.size() ; j++) {
                String blockJ = StringUtil.applySha256(blockchainList.get(j).getId()+blockchainList.get(j).getTimeStamp()+blockchainList.get(j).getHashOfPreviousBlock());
                if(blockI.equals(blockJ)){
                    return false;
                }
            }
        }
        return true;
    }

    public List<Block> getBlockchainList() {
        return blockchainList;
    }
}
