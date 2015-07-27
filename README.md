```
                                                                           
   _|_|_|    _|_|    _|      _|  _|_|_|_|    _|_|_|    _|_|    _|_|_|_|_|  
 _|        _|    _|  _|      _|  _|        _|        _|    _|      _|      
 _|        _|_|_|_|  _|      _|  _|_|_|    _|        _|_|_|_|      _|      
 _|        _|    _|    _|  _|    _|        _|        _|    _|      _|      
   _|_|_|  _|    _|      _|      _|_|_|_|    _|_|_|  _|    _|      _|      
                                                                           
```


#CaveCat Wiki(가칭)

[![Join the chat at https://gitter.im/sukmin/cavecat](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/sukmin/cavecat?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

## Server Framework
1. Spring 4.x
2. Hibernate ORM 4.x

## GFM을 지원하는 라이브러리 선정
1. [Strapdown.js](http://strapdownjs.com/)
2. [marked](https://github.com/chjj/marked)

## DB 모델링
1. 키워드 테이블( 키워드만 저장하는 테이블 )
2. 컨텐츠 테이블( 마크다운을 저장하는 테이블 )
	- 키워드테이블과 1:n 관계를 가진다.
	- 수정은 없고 무조건 등록만 있다.
3. 유저 테이블( email, password, name )
4. 권한 테이블

## 메인페이지 개발
1. 공개된 부트스트랩 템플릿 사용

## 페이지 히스토리 관리 기능 개발
1. 오픈소스 사용 예정

## 권한 관리 기능 개발

## 예정 사항
1. 분류(카테고리) 또는 태그 시각화로 멋있게 보여주기
2. 검색 횟수에 우선순위를 두어 보여주기 (선호도)
