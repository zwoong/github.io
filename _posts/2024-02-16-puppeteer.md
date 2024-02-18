---
layout: post
title: Puppeteer
tags: [Research, Puppeteer란]
categories: [Research, Puppeteer란]
image:
  path: /assets/img/post/research/puppeteer.jpeg
  alt: puppeteer
date: 2024-02-17 20:30 +0900
---

## puppeteer

Puppeteer는 **DevTools 프로토콜**을 통해 **Chrome/Chromium을 제어**하기 위한 고급 API를 제공하는 Node.js 라이브러리다.

- **DevTools**
  - 웹 브라우저의 **개발자 도구와 연결되어 통신하는 데 사용되는 프로토콜**
  - DevTools 프로토콜은 주로 **웹 소켓(HTTP 핸드쉐이크 이후)을 통해 통신**하며, JSON 형식으로 메시지를 교환한다.

![developer-tools](/assets/img/post/research/developer-tools.png){: width=＂500＂ }

- **DevTools Protocol**

![devtools-protocol](/assets/img/post/research/devtools-protocol.jpg){: width=＂500＂ }

- **Chromium**
  - Chromium은 오픈 소스 프로젝트로, **Google Chrome의 기초가 되는 소스 코드**이다. (Chrome의 엄마라고 보면 됨)
  - **Chrome과 차이점**
    - **소스 코드와 라이선스**
      - **Chromium**: 오픈 소스 프로젝트로, 소스 코드가 공개되어 있으며 누구나 참여하고 기여할 수 있다.
      - **Chrome**: Chromium을 기반으로 만들어진 브라우저이지만, **Google이 제공하는 상용 제품이므로 소스 코드의 일부는 공개되어 있지 않다**.
    - **기본 제공 기능**
      - **Chromium**: Google 서비스와 추가적인 기능이 포함되어 있지 않다. **기본적인 브라우저 기능만을 제공**한다.
      - **Chrome**: 웹 스토어에서 **다양한 확장 프로그램과 기능을 제공**한다. 또한 Chrome Sync를 통해 즐겨찾기, 확장 프로그램, 비밀번호 등을 동기화할 수 있습니다.
    - **보안 및 안정성**:
      - **Chromium**: 오픈 소스 프로젝트이기 때문에 개발 중인 기능이나 수정 사항이 매우 빈번하게 발생하고 이는 실험적인 기능이나 아직 안정화되지 않은 코드를 포함할 가능성이 있어 **Chrome보다 안정성이 훨씬 떨어지고 더 많은 버그가 발생**한다고 한다.
      - **Chrome**: Google에서 **지속적으로 보안 패치와 업데이트를 제공하여 안정성을 유지**하며, **Chromium에 비해 훨씬 적은 버그가 발생**한다.

![chromium-chrome](/assets/img/post/research/chromium-chrome.webp){: width=＂500＂ }

### 환경 셋팅

이제 본격적으로 puppeteer 사용법에 대해 알아보자.

- **예제**
  - 필자는 햄버거(🍔)를 사랑하고 그 중에 맥도날드를 특히 좋아하기에 **맥도날드 메뉴가 노출되는 페이지에서 햄버거 이름과 이미지 경로를 가져오는 기능**을 만들어보자.
  - 맥도날드 홈페이지를 접속해 가져오고 싶은 리스트를 찾는다.
    - 이는 생각보다 간단한데 개발자 도구를 켜서 CSS Selector를 통해 추출하고 싶은 영역을 선택해주면 된다.
    - 내가 선택한 영역은 class="menuList"이다.
      - ![puppeteer-mcdonalds-ex1](/assets/img/post/research/puppeteer-mcdonalds-ex1.png){: width=＂500＂ }
    - menuList 클래스명을 가진 `ul`태그 밑에는 여러개의 `li`태그가 보인다.
      - `li` 태그 안에는 `a` 태그가 존재하고 `a` 태그는 class 명이 thum, name 각각 2개의 `div` 태그가 존재한다.
      - thumb 내에는 `img` 태그에 src 값을 name 내에는 class명이 .ko .en인 `div` 태그에 값을 가져와 보자. 😉
      - ![puppeteer-mcdonalds-ex2](/assets/img/post/research/puppeteer-mcdonalds-ex2.png){: width=＂500＂ }

<!--  -->

**puppeteer 라이브러리 설치**

```sh
npm i puppeteer
# or using yarn
yarn add puppeteer
```

### 예제 코드

```js
import puppeteer from "puppeteer";

async function run() {
  // Launch the browser
  const browser = await puppeteer.launch();

  // Create a page
  const page = await browser.newPage();

  // Navigate the page to a URL
  await page.goto("https://www.mcdonalds.co.kr/kor/menu/list.do");

  const burgers = await page.evaluate(() => {
    const anchors = Array.from(document.querySelectorAll(".menuList li a"));

    return anchors.map((anchor) => {
      const nameKO =
        anchor.querySelector(".thumb .ko")?.innerText || "No Name KO";
      const nameEN =
        anchor.querySelector(".name .en")?.innerText || "No Name EN";
      const image = anchor.querySelector(".thum img");
      const imageUrl = image ? image.src : "No Image";
      return { nameKO, nameEN, imageUrl };
    });
  });

  console.log(burgers);

  // Close the browser instance
  await browser.close;
}

run().catch((error) => {
  console.error("An error occurred:", error);
});
```

### 결과

```shell
[
  {
    nameKO: '더블 쿼터파운더® 치즈',
    nameEN: 'Double Quarter Pounder® with Cheese',
    imageUrl: 'https://www.mcdonalds.co.kr/upload/product/pcList/1583727487454.png'
  },
  {
    nameKO: '쿼터파운더® 치즈 BBQ 베이컨',
    nameEN: 'Quarter Pounder® Cheese BBQ Bacon',
    imageUrl: 'https://www.mcdonalds.co.kr/upload/product/pcList/1705473261789.png'
  },
  {
    nameKO: '쿼터파운더® 치즈',
    nameEN: 'Quarter Pounder® with Cheese',
    imageUrl: 'https://www.mcdonalds.co.kr/upload/product/pcList/1583728183515.png'
  },
  {
    nameKO: '빅맥®',
    nameEN: 'Big Mac®',
    imageUrl: 'https://www.mcdonalds.co.kr/upload/product/pcList/1583727841393.png'
  },
  ...
]
```
