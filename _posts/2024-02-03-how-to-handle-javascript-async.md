---
layout: post
title: 자바스크립트 비동기 처리 방법
tags: [Research, javascript, 자바스크립트 비동기 처리 방법]
categories: [Research, javascript, 자바스크립트 비동기 처리 방법]
image:
  path: /assets/img/post/research/how-to-handle-javascript-async.webp
  alt: how-to-handle-javascript-async
date: 2024-02-04 15:41 +0900
---

자바스크립트에서 비동기 처리는 주로 **콜백 함수, 프로미스, 그리고 async/await를 사용하여 수행**된다. 각각의 특성과 사용 방법, 장단점을 자세히 살펴보자. 😉

## 콜백(Callback)

콜백 함수는 **다른 함수에 인자로 전달되는 함수**로, 어떤 **이벤트가 발생한 후 또는 특정 작업이 완료된 후에 호출**된다.

- **작동 방식**
  - A 함수에 B 함수를 인자로 넘겨주고, A 함수의 처리가 끝나면 B 함수를 호출한다.
  - 비동기 작업(예: 파일 읽기, 요청 보내기 등)에 대한 콜백을 등록하고, 작업 완료 후 콜백이 실행된다.
- **장단점**
  - **장점**
    - **간단하고 직관적**인 비동기 처리 방식
    - 모든 자바스크립트 환경에서 널리 사용된다.
  - **단점**
    - 중첩된 콜백 함수(콜백 지옥)로 인해 **코드의 가독성과 유지보수성이 떨어진다**.
    - 에러 처리가 복잡하고, 콜백 체인의 어느 부분에서 에러가 발생했는지 추적하기 어렵다.

```javascript
function fetchData(callback) {
  setTimeout(() => {
    callback(null, "Data fetched using callback");
  }, 2000);
}

fetchData((error, data) => {
  if (error) {
    console.error(error);
    return;
  }
  console.log(data); // 'Data fetched using callback'
});
```

- **콜백 지옥 예시**

```javascript
// 첫 번째 데이터를 가져오는 비동기 함수
function fetchData1(callback) {
  setTimeout(() => {
    console.log("Data 1 fetched");
    callback(null, "Data1");
  }, 1000);
}

// 두 번째 데이터를 가져오는 비동기 함수
function fetchData2(data1, callback) {
  setTimeout(() => {
    console.log("Data 2 fetched");
    callback(null, "Data2");
  }, 1000);
}

// 세 번째 데이터를 가져오는 비동기 함수
function fetchData3(data2, callback) {
  setTimeout(() => {
    console.log("Data 3 fetched");
    callback(null, "Data3");
  }, 1000);
}

// 콜백 지옥 예시
fetchData1((error1, data1) => {
  if (error1) {
    console.error(error1);
    return;
  }
  fetchData2(data1, (error2, data2) => {
    if (error2) {
      console.error(error2);
      return;
    }
    fetchData3(data2, (error3, data3) => {
      if (error3) {
        console.error(error3);
        return;
      }
      console.log("All data fetched:", data1, data2, data3); // Data1, Data2, Data3
    });
  });
});
```

## 프로미스 (Promises)

프로미스는 **비동기 작업의 결과를 나타내는 객체**이다. 프로미스는 세 가지 상태를 가진다. <br>
**대기(pending), 이행(fulfilled), 거부(rejected)**

- **작동 방식**
  - **new Promise를 통해 프로미스 객체를 생성하고, 비동기 작업을 수행**한다.
  - 비동기 작업이 **성공적으로 완료되면 resolve 함수를 호출**하고, **실패하면 reject 함수를 호출**한다.
  - **.then() 메서드를 사용하여 이행 상태의 결과를 처리**하고, **.catch() 메서드를 사용하여 거부 상태의 결과를 처리**한다.
- **장단점**
  - **장점**
    - **콜백 지옥 문제를 해결**하고, **체이닝을 통해 가독성 좋은 코드를 작성**할 수 있다.
    - 중앙집중식 에러 처리가 가능하다.
  - **단점**
    - 프로미스가 한 번 거부되면 다시 재시도할 수 없다.
    - 프로미스를 과도하게 사용하면 코드가 복잡해질 수 있다.

```javascript
function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data fetched using promise");
    }, 2000);
  });
}

fetchData()
  .then((data) => console.log(data)) // 'Data fetched using promise'
  .catch((error) => console.error(error));
```

### Promise.all

Promise.all은 여러 프로미스를 병렬로 처리할 때 사용한다. **모든 프로미스가 이행되면, 각 프로미스의 결과를 모아 배열로 반환**한다. **하나라도 거부되면, Promise.all은 즉시 거부**된다.

```javascript
let promise1 = Promise.resolve("Promise 1 resolved");
let promise2 = new Promise((resolve, reject) => {
  setTimeout(resolve, 2000, "Promise 2 resolved");
});
let promise3 = new Promise((resolve, reject) => {
  setTimeout(resolve, 2000, "Promise 3 resolved");
});

Promise.all([promise1, promise2, promise3])
  .then((values) => console.log(values)) // ['Promise 1 resolved', 'Promise 2 resolved', 'Promise 3 resolved']
  .catch((error) => console.error(error));
```

## async/await

async/await는 **비동기 코드를 동기 코드처럼 보이게 하고 작성**할 수 있게 하는 ES2017(ES8)에서 소개된 문법이다.

- **작동 방식**
  - async 함수는 항상 프로미스를 반환한다.
  - 함수 내부에서 **await 키워드를 사용하여 프로미스의 이행(fulfilled) 결과**를 기다린다.
  - await 키워드는 async 함수 내에서만 유효하다.
- **장단점**
  - **장점**
    - **동기 코드와 유사한 형태로 비동기 코드를 작성할 수 있어 가독성이 매우 높다**.
    - try/catch 블록을 사용한 일관된 에러 처리가 가능하다.
  - **단점**
    - await 키워드를 남용하면 순차적인 코드 실행으로 인해 성능 문제가 발생할 수 있다.

```javascript
async function fetchData() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("Data fetched using async/await");
    }, 2000);
  });
}

async function showData() {
  try {
    const data = await fetchData();
    console.log(data); // 'Data fetched using async/await'
  } catch (error) {
    console.error(error);
  }
}

showData();
```
