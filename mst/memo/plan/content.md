콘텐츠
===

콘텐츠에 대한 프로젝트 정의를 정리한 문서임.

1. 콘텐츠 항목

- contentId
- point
- regDate
- modDate


- 점수 (월드컵 게임을 통해서 자동으로 채점되는 방식임)
- 게시일자, 수정일자


콘텐츠 파일
---

- contentId key
- fileSrc key
- fileType key
- highlight

한 컨텐츠는 종류마다 여러개의 파일이 존재할 수 있음 (이미지, 동영상, 음악 등)
즉, 컨텐츠와 컨텐츠파일은 N:1 관계로 사용되어, 여러개를 추가할 수 있는 구조이며, 파일 타입으로 구분이 됨

이하 컨텐츠 종류마다 필요한 필드와, 파일들을 정리한다.


파일 타입 정의
---

- SONG (음악)
- SCENE (명장면 영상)
- MV (오프닝, 엔딩 영상)
- MAIN_IMG (대표 이미지)
- IMG (이미지)



음악
---

- title
- vocal
- composition
- musicType

SONG, MAIN_IMG 파일 필수 (월드컵 할 때 사용됨)
MV 선택


애니
---

게임
---

미연시
---

