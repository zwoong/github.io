---
layout: post
title: MTV pattern
tags: [Research, Django, MTV pattern]
categories: [Research, Django, MTV pattern]
image:
  path: /assets/img/post/research/mtv-pattern.jpeg
  alt: mtv-pattern
date: 2024-03-08 15:52 +0900
---

## MTV pattern

Django의 MTV 패턴은 웹 개발에서 널리 사용되는 **MVC (Model-View-Controller) 패턴을 기반으로 한 디자인 패턴**이다. Django에서는 MVC를 조금 변형하여 MTV (Model-Template-View)로 명명한다. 이 패턴은 애플리케이션의 **데이터 처리 로직(Model)**, **사용자 인터페이스(Template)**, 그리고 **애플리케이션의 제어 흐름을 관리하는 부분(View)으로 구성**됩니다. 각각의 컴포넌트는 독립적으로 작동하며, 특정 기능을 수행한다.

### Model

Model은 **애플리케이션의 데이터 구조를 정의하고 데이터베이스와의 상호 작용을 처리**한다. Django의 ORM (Object-Relational Mapping)을 사용하여, 데이터베이스의 테이블을 Python 클래스로 표현한다. 이 클래스들은 데이터베이스에서 데이터를 쿼리하거나 저장하는데 사용된다. Model은 또한 데이터의 유효성 검사, 데이터베이스 레코드의 추가, 수정, 삭제 등의 작업을 캡슐화한다.

### Template

Template은 **사용자에게 보여질 웹 페이지의 구조와 레이아웃을 정의**한다. Django의 템플릿 시스템을 사용하여 HTML 파일 안에 파이썬 코드를 삽입할 수 있게 해주며, 이를 통해 동적인 웹 페이지를 생성할 수 있다. **Template은 MVC의 View와 유사**하지만, Django에서는 사용자에게 보여지는 인터페이스를 담당한다는 점에서 Template라고 명명한다.

### View

View는 **사용자의 요청을 받아 처리하고 응답을 반환하는 역할**을 한다. 이는 **MVC의 Controller와 유사한 역할을 수행**하며, View는 사용자로부터 받은 요청의 유형을 파악하고, 필요한 데이터를 Model로부터 가져오거나 업데이트한다. 그런 다음, 적절한 Template를 선택하고, Template에 데이터를 전달하여 사용자에게 최종적인 응답을 생성한다. **View는 애플리케이션의 비즈니스 로직을 처리하며, 다양한 HTTP 메소드(GET, POST 등)에 대응하는 로직을 구현**한다.

![mtv-flow](/assets/img/post/research/mtv-flow.png){: width=＂700＂ }

## 예시

간단한 블로그 애플리케이션을 가정하며, 사용자가 게시물을 조회할 수 있는 기능을 구현해보자.

- **Model**
  - `models.py` 파일에는 블로그 게시물을 위한 Post 모델이 정의된다. 이 모델은 Django의 models.Model 클래스를 상속받아 게시물의 제목과 내용을 저장한다.

```py
from django.db import models

class Post(models.Model):
    title = models.CharField(max_length=200)
    content = models.TextField()

    def __str__(self):
        return self.title
```

- **Template**
  - `post_list.html` 파일에는 **사용자에게 게시물 목록을 보여주기 위한 HTML 템플릿이 정의**된다. Django 템플릿 태그를 사용하여 서버에서 전달한 게시물 데이터를 동적으로 표시한다.

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Blog Posts</title>
  </head>
  <body>
    <h1>Blog Posts</h1>
  </body>
</html>
```

- **View**
  - `views.py` 파일에는 **사용자의 요청에 따라 게시물 목록을 반환하는 post_list 뷰가 정의**된다. 이 뷰는 Post 모델에서 모든 게시물을 조회한 후, post_list.html 템플릿에 전달하여 사용자에게 게시물 목록을 보여준다.

```py
from django.shortcuts import render
from .models import Post

def post_list(request):
    posts = Post.objects.all()
    return render(request, 'post_list.html', {'posts': posts})
```

## MTV 패턴의 장점

- **분리된 관심사**: MTV 디자인 패턴은 **애플리케이션의 다양한 관심사를 분리**함으로써, 코드의 **유지보수와 관리를 용이하게 한다**. 개발자는 모델, 뷰, 템플릿을 개별적으로 수정할 수 있으며, 이는 애플리케이션의 확장성과 유연성을 향상시킨다.
- **재사용성**: **모델과 템플릿은 여러 뷰에서 재사용될 수 있다**. 이는 코드의 중복을 줄이고, 개발 시간을 단축시킨다.
- **개발 효율성**: Django는 MTV 패턴을 기반으로 하여 다양한 내장 기능을 제공한다. 이러한 기능들은 개발 프로세스를 간소화하고, 개발자가 더 복잡한 애플리케이션 로직에 집중할 수 있도록 도와준다.
