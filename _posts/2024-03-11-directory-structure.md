---
layout: post
title: 디렉토리 구조
tags: [Research, Django, 디렉토리 구조]
categories: [Research, Django, 디렉토리 구조]
image:
  path: /assets/img/post/research/django-directory-structure.png
  alt: django-directory-structure
date: 2024-03-11 22:00 +0900
---

## 프로젝트 디렉토리 구성 요소

`django-admin startproject` **명령을 사용하여 생성된 디렉토리**이다. 이 디렉토리 이름은 보통 프로젝트의 이름과 같으며, 프로젝트의 설정 파일, 애플리케이션 디렉토리, 그리고 다양한 구성 파일들이 위치한다.

```bash
myproject/
    manage.py # django-admin startproject 명령어를 통해 생기는 커맨드라인 유틸리티
    myproject/ # 프로젝트 디렉토리
        __init__.py
        settings.py
        urls.py
        asgi.py
        wsgi.py
```

- **manage.py**: **Django 프로젝트와 관련된 다양한 명령을 실행할 수 있는 커맨드라인 유틸리티**이다. 예를 들어, 데이터베이스 마이그레이션, 서버 실행 등의 작업을 할 수 있다.

- **프로젝트 설정 디렉토리(project_name)**: 이 디렉토리는 프로젝트의 이름과 같으며, 설정 파일들을 포함하고 있다.
  - **init.py**: Python에서 **현재 디렉토리를 패키지로 인식**하게 하는 빈 파일이다.
  - **settings.py**: 프로젝트의 설정을 포함하는 파일이다. **데이터베이스 설정, 인증 시스템, 템플릿 설정 등을 정의**한다.
  - **urls.py**: 프로젝트의 **URL 선언을 저장**한다. Django에서는 이 파일을 URLconf(URL configuration)라고 부른다.
  - **asgi.py와 wsgi.py**: 프로젝트를 서비스하기 위한 Asynchronous Server Gateway Interface와 Web Server Gateway Interface의 설정 파일이다. 각각 **비동기식 및 동기식 서버 환경에서 Django 애플리케이션을 실행하는 데 사용**된다.

## 애플리케이션 디렉토리

```bash
myproject/
    manage.py # django-admin startproject 명령어를 통해 생기는 커맨드라인 유틸리티
    myproject/ # 프로젝트 디렉토리
        __init__.py
        settings.py
        urls.py
        asgi.py
        wsgi.py
    app1/ # 애플리케이션 디렉토리
        migrations/
            __init__.py
        __init__.py
        admin.py
        apps.py
        models.py
        tests.py
        views.py
        urls.py  # 앱 수준의 URL 설정 (선택적)
    app2/ # 애플리케이션 디렉토리
        ...  # 앱2의 구조도 app1과 유사
    static/
        css/
        images/
        js/
    templates/
        app1/
        app2/
```

- **admin.py**: 관리자 사이트에서 이 애플리케이션의 **모델을 관리할 수 있도록 설정**한다. 이 파일에서 모델을 관리자 사이트에 등록하여, 데이터를 쉽게 추가, 수정, 삭제할 수 있는 인터페이스를 제공한다.
- **apps.py**: 애플리케이션의 구성(class-based configuration)을 포함한다. 여기서 **애플리케이션의 이름, 레이블 등을 설정**할 수 있으며, 이는 Django 프로젝트 전체에서 애플리케이션을 구별하는 데 사용된다.
- **models.py**: 이 애플리케이션의 데이터 모델을 정의한다. Django ORM(Object-Relational Mapping)을 사용하여 **데이터베이스 스키마(테이블, 필드 등)를 Python 클래스로 표현**한다. 이 파일에서 정의된 모델을 통해 데이터베이스 쿼리를 수행할 수 있다.
- **tests.py**: 애플리케이션의 테스트 케이스를 포함한다. 이 파일을 사용하여 **단위 테스트를 작성하고 실행**할 수 있으며, 이는 애플리케이션의 기능이 의도한 대로 작동하는지 확인하는 데 사용된다.
- **views.py**: 애플리케이션의 뷰를 정의한다. 뷰는 **웹 요청을 받아 처리하고, 응답을 반환하는 함수 또는 클래스**이다. **여기서 비즈니스 로직을 구현**하고, 모델로부터 데이터를 조회하거나 저장한 후, 적절한 템플릿과 함께 렌더링 된 HTML 페이지를 사용자에게 반환한다.
- **urls.py** (선택적): **애플리케이션 수준의 URL 경로를 정의**한다. Django 프로젝트는 urls.py 파일을 사용하여 URL 패턴을 뷰에 매핑한다. 이 파일은 프로젝트의 메인 urls.py 파일에 포함될 수 있으며, 애플리케이션 내의 특정 뷰로 요청을 라우팅하는 데 사용된다.
- **migrations/**: 데이터베이스 **마이그레이션 파일들을 저장하는 디렉토리**이다. models.py에서 모델을 변경할 때마다, Django는 이 **변경사항을 데이터베이스 스키마에 적용하기 위한 마이그레이션 파일을 생성**할 수 있다.
