package com.bts.db.service;

import com.bts.db.domain.*;
import com.bts.db.repository.NftRepository;
import com.bts.db.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class NftServiceImpl implements NftService{
    private final NftRepository nftRepository;
    private final UserRepository userRepository;
    Integer num = 8;

    @Override
    public HashMap<String, String> saveNft(NFTDto Nftdto) {
        User user = userRepository.findByuserId(Nftdto.getOwner()).orElse(null);

        NFT nft = NFT.builder().id(Nftdto.getId())
                .name(Nftdto.getName())
                .date(Nftdto.getDate())
                .description(Nftdto.getDescription())
                .image(Nftdto.getImage())
                .userId(user)
                .imagepath(Nftdto.getImagepath())
                .build();
        nftRepository.save(nft);
        HashMap<String, String> status = new HashMap<>();
        status.put("status","OK");
        num++;
        return status;
    }

    @Override
    public List<NFT> findNft(Long id) {
        User user = userRepository.findByuserId(id).orElse(null);
        List<NFT> nfts = nftRepository.findByuserId(user);
        return nfts;
    }

    @Override
    public List findNftByNftId(String nftid) {
        List<NFT> nfts = nftRepository.findById(nftid);
        return nfts;
    }
    @Override
    public List<NFT> findNftAll(){
        List<NFT> nfts = nftRepository.findAll();
        System.out.println(nfts);
        return nfts;
    }

    @Override
    public HashMap<String, String> moveNft(SendDto sendDto) {
        List<NFT> nft = nftRepository.findById(sendDto.getId());
        User user = userRepository.findByuserId(Long.parseLong(sendDto.getTo())).orElse(null);
        NFT pick = nft.get(0);
        NFT remove = pick;
        remove.setUserId(user);
        remove.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        nftRepository.save(remove);
        HashMap<String, String> status = new HashMap<>();
        status.put("status","OK");
        return status;
    }

    @Override
    public HashMap<String, String> deleteNft(DeleteDto deleteDto) {
        List<NFT> nft = nftRepository.findById(deleteDto.getId());
        NFT pick = nft.get(0);
        nftRepository.delete(pick);
        HashMap<String, String> status = new HashMap<>();
        status.put("status","OK");
        return status;
    }


}
