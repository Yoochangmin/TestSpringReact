package jpabook.springjpashop.service;

import jpabook.springjpashop.Entity.MakeSentence.MakeSentenceEntity;
import jpabook.springjpashop.Entity.MakeSentence.PatentSentenceEntity;
import jpabook.springjpashop.dto.MakeSentence.PatentSentenceDto;
import jpabook.springjpashop.dto.ResponseDto;
import jpabook.springjpashop.repository.MakeSentenceRepository;
import jpabook.springjpashop.repository.PatentSentenceJpaRepository;
import jpabook.springjpashop.repository.PatentSentenceReopsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatentSentenceService {

    @Autowired
    private final PatentSentenceJpaRepository patentSentenceJpaRepository;
    @Autowired
    private final PatentSentenceReopsitory patentSentenceRepository;

    @Autowired
    private final MakeSentenceRepository makeSentenceRepository;


    //연관단어 저장
    public ResponseDto<?> saveSentence(PatentSentenceDto dto, Long makeSentenceId){
        MakeSentenceEntity makeSentenceEntity = makeSentenceRepository.findById(makeSentenceId).orElse(null);
        PatentSentenceEntity patentSentenceEntity = new PatentSentenceEntity(dto);
        patentSentenceEntity.setMakeSentenceEntity(makeSentenceEntity);
        //데이터베이스에 patentSentence 저장
        try {
            patentSentenceJpaRepository.save(patentSentenceEntity);
        }catch (Exception e){
            return ResponseDto.setFailed("Nodes Save Faild!");
        }
        return ResponseDto.setSuccess("Save Success!", dto);
    }
    //연관단어 리스트 불러오기
//    public ResponseDto<?> getPatentList(Long id){
//        System.out.println("여기까지는 되냐" +id);
//        Optional<MakeSentenceEntity> MakeSentenceEntityId = makeSentenceRepository.findById(id);
//        if (MakeSentenceEntityId.isPresent()) {
//            System.out.println( MakeSentenceEntityId.get());
//        } else {
//            System.out.println( "데이터 없음");
//        }
//        List<PatentSentenceEntity> makeSentencId = patentSentenceRepository.findMakeSentencId(id);
//        return null;
////        return ResponseDto.setSuccess("Success message", patentSentenceEntityList);
//    }

    public ResponseDto<?> getPatentList(Long id) {
        List<String> patentList = new ArrayList<>();

        Optional<MakeSentenceEntity> makeSentenceEntityOptional = makeSentenceRepository.findById(id);
        if (makeSentenceEntityOptional.isPresent()) {
            System.out.println("옵셔널 데이터" + makeSentenceEntityOptional.get());
        } else {
            System.out.println( "데이터 없음");
        }
        Long idx = makeSentenceEntityOptional.get().getId();

        List<PatentSentenceEntity> makeSentenceId = patentSentenceRepository.findByMakeSentenceId(idx);
            // 처리 로직 추가
        System.out.println(makeSentenceId);
        return ResponseDto.setSuccess("PatentSentence 정보 조회 성공",  makeSentenceId);
    }

}
