var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click' , function() {
            _this.save();
        });
        $('#btn-update').on('click' , function() {
            _this.update();
        });
        $('#btn-delete').on('click' , function() {
            _this.delete();
        });
        $('#btn-reservation').on('click' , function() {
            _this.reservationSave();
        });

        const wrapper = document.getElementById("instagram");
        fetch("https://www.instagram.com/atthej_makeup2/")
        .then(a => {
            return a.text();
        }).then(a => {
            const media = JSON.parse(a.slice(a.indexOf("edge_owner_to_timeline_media") + 30, a.indexOf("edge_saved_media") - 2));
            media.edges.forEach(m => {
                const node = m.node,
                    div3 = document.createElement("div"),
                    div2 = document.createElement("div"),
                    a = document.createElement("a"),
                    img = document.createElement("img");

                div3.className="member portfolio-wrap",
                div2.className= "col-lg-3 col-md-6 wow fadeInUp portfolio-item",
                a.target="_blank",
                a.href = `https://www.instagram.com/p/${node.shortcode}/`,
                img.className = "img-fluid",
                img.src = node.display_url,


                a.append(img),
                div3.append(a),
                div2.append(div3),
                wrapper.append(div2)
            })
        })

    },
    save : function(){
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };
        $.ajax({
            type : 'POST' ,
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 등록 되었습니다.');
            window.location.href = '/notice';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    },
    reservationSave : function(){
        var data = {
            name : $('#name').val(),
            phnNo : $('#phnNo').val(),
            sex : $('#sex').val(),
            date : $('#date').val(),
            time : $('#time').val(),
            type : $('#type').val(),
            personNo : $('#personNo').val(),
            realSender : $('#realSender').val(),
            comment : $('#comment').val(),
            privacyPermission : $('#privacyPermission').val()
        };
        $.ajax({
            type: 'POST' ,
            url : '/api/v1/reservation',
            dataType : 'json' ,
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('예약이 완료 되었습니다.');
            window.location.href = '/index';
        }).fail(function() {
            //alert(JSON.stringify(error));
            alert(err);
        });
    },
    update : function() {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type : 'PUT' ,
            url : '/api/v1/posts/' + id ,
            dataType : 'json' ,
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
