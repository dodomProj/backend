# 도돔 :sparkles: 

<br/>

**`팀 이름` :**  두룹<br/>
**`프로젝트 기간` :** 2023.05.04. - 2023.06.30<br/>
**`배포 링크`:** [dodom.site](https://dodom.site/) <br/>

## ✨ 기능 소개

<details>
<summary><b>메인 화면</b></summary>
<div markdown="1"><br/>
  
![main](https://github.com/dodomProj/dodom_front/assets/62418379/bd29605b-091a-4f08-8bb8-8dc5835fd360)

</div>
</details>
<details>
<summary><b>마음 일기 - 상담 예약</b></summary>
<div markdown="1"><br/>

https://github.com/dodomProj/dodom_front/assets/62418379/997fceae-cefc-4e78-8905-131e51b5a9be


</div>
</details>
<details>
<summary><b>심리 검사 - 상담 예약</b></summary>
<div markdown="1"><br/>

https://github.com/dodomProj/dodom_front/assets/62418379/2dc75853-4635-4c3d-b18e-b84b10e3c9c6


</div>
</details>
<details>
<summary><b>상담사 소개</b></summary>
<div markdown="1"><br/>

https://github.com/dodomProj/dodom_front/assets/62418379/58814861-feea-424b-bd1a-50145c51cf39

</div>
</details>

<details>
<summary><b>상담 후기 작성</b></summary>
<div markdown="1"><br/>

https://github.com/dodomProj/dodom_front/assets/62418379/332f2a22-0d5b-4d8c-b9fe-bd86cd8c1f03

</div>
</details>

<details>
<summary><b>지원 정책 소개</b></summary>
<div markdown="1"><br/>

https://github.com/dodomProj/dodom_front/assets/62418379/a2d95f0c-a138-4dc0-b783-b924d136d152

</div>
</details>

## 🙋 Member
|[강은서<br>(BE)](https://github.com/kdmstj)|[조윤희<br>(FE)](https://github.com/YUNH7)|[차세진<br>(FE)](https://github.com/chasj0326)|
| :----------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------: |
| <img alt="강은서" src="https://avatars.githubusercontent.com/u/62414231?v=4" height="100" width="100"> |<img alt="조윤희" src="https://avatars.githubusercontent.com/u/113083398?v=4" height="100" width="100"> |<img alt="차세진" src="https://avatars.githubusercontent.com/u/62418379?v=4" height="100" width="100">|
|<p align="left">**AWS 배포**<br/>&ensp;﹒s3 정적웹사이트 https 적용<br/>&ensp;﹒ec2 API 서버 https 적용<br/>&ensp;﹒가비아 도메인 적용<br/>**상담 예약**<br/>&ensp;﹒예약 완료 이메일 전송 기능<br/>**리뷰 작성 및 조회**<br/>&ensp;﹒이메일 리뷰 페이지 연결<br/>**상담사 등록 및 조회**<br/>**웹사이트 방문자 수 등록 및 조회**</p>| <p align="left" >- 심리 검사 페이지(나의 상태)<br/>&ensp;+ 테스트 객체에서 필요한 정보<br/>&ensp;&ensp;&ensp;(테스트 종류, 질문/답변/결과)만<br/>&ensp;&ensp;&ensp;찾아 리턴하는 커스텀 훅 작성<br/>- 상담사 소개 페이지<br/>&ensp;+ 상담폼 상담사 더보기와<br/>&ensp;&ensp;&ensp;조건부 렌더링으로 같이 사용,<br/>&ensp;&ensp;&ensp;상담폼 관련 데이터가 없다면<br/>&ensp;&ensp;&ensp;리다이렉트<br/>&ensp;&ensp;&ensp;(/reserve/counsel > /counsel)<br/>- 정책 소개 페이지(추천 사업)<br/>- 만족도 조사 페이지(설문조사)<br/>&ensp;+ api 응답에 따라<br/>&ensp;&ensp;&ensp;이미 리뷰가 등록된 후기라면<br/>&ensp;&ensp;&ensp;메인으로 리다이렉트<br/>- Loading, 404 페이지<br/>- 캐러셀, 별점 컴포넌트 적용<br/>- CICD<br/>&ensp;Github actions로 AWS S3 자동 배포<br/><br/>**Create** :<br/>- 사이트에 접근 시 방문자수 +1<br/>- 상담 예약<br/>- 상담 후기 등록<br/>**Read** :<br/>- 상담사 정보 조회<br/>- 정책 관련 Notion 데이터 조회<br/>- 예약 번호로 상담사Id,<br/>&ensp; 후기 등록 여부 조회<br/>- 후기 조회 | <p align="left">**프로젝트 초기 세팅**<br/>**메인 페이지**<br/>**소개 페이지(도돔 소개)**<br/>**일기 작성 페이지(마음 일기)**<br/>&ensp;- 일기에 특정 키워드가 포함된 경우<br/>&ensp;&ensp;우울증 전문 상담사 매칭<br/>&ensp;&ensp;아니라면 건강 상담사 매칭<br/>&ensp;- 로컬에 이미지 저장 기능 구현<br/><br/>**Create** :<br/>- 상담 예약 |

<br/>


<br/>

## <span style=""> ⚙️ **Tools** </span>
| Github | Discord |Notion |
| :---: | :---: |:---:|
| <img alt="github logo" src="https://techstack-generator.vercel.app/github-icon.svg" width="65" height="65"> | <img alt="Discord logo" src="https://assets-global.website-files.com/6257adef93867e50d84d30e2/62595384e89d1d54d704ece7_3437c10597c1526c3dbd98c737c2bcae.svg" height="65" width="65"> |<img alt="Notion logo" src="https://www.notion.so/cdn-cgi/image/format=auto,width=640,quality=100/front-static/shared/icons/notion-app-icon-3d.png" height="65" width="65">|

### <span style="">🔒  **Back-end** </span>
| Java | mySQL | AWS | Spring | Spring<br>Boot | Spring<br/>Security
| :---: | :---: | :---: | :---: | :---: | :---: |
| <div style="display: flex; align-items: flex-start;"><img src="https://techstack-generator.vercel.app/java-icon.svg" alt="icon" width="65" height="65" /></div> | <div style="display: flex; align-items: flex-start;"><img src="https://techstack-generator.vercel.app/mysql-icon.svg" alt="icon" width="65" height="65" /></div> | <div style="display: flex; align-items: flex-start;"><img src="https://techstack-generator.vercel.app/aws-icon.svg" alt="icon" width="65" height="65" /></div> | <img alt="spring logo" src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" height="50" width="50" > | <img alt="spring-boot logo" src="https://t1.daumcdn.net/cfile/tistory/27034D4F58E660F616" width="65" height="65" > | <img alt="spring-boot logo" src="https://blog.kakaocdn.net/dn/dIQDQP/btqZ09ESd8T/0ibqtotW52OaJS8HznXDQK/img.png" width="65" height="65" >|

<br/>

## <span style=""> ⚙️ **Project Architecture** </span>

<img width="1004" alt="image" src="https://github.com/dodomProj/backend/assets/62414231/4cf2f1e5-d026-4fea-ba5f-7db5711826c4">


<br/>

## :notebook: Documentation

[API 명세서](https://documenter.getpostman.com/view/21233893/2s93sf3BQb)

[ERD](https://dbdiagram.io/d/648265fa722eb77494a80290)

<br/>

