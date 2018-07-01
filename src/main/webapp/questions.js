var questionRestUrl = 'api/questions';

function rest(restUrl, httpMethod, param, contenttype, datatype, callback) {
    jQuery('#resultDiv').html("Loading...");
    var request = jQuery.ajax({
        type: httpMethod,
        url: restUrl,
        data: param,
        contentType: contenttype,
        dataType: datatype
    });
    request.done(function (data) {
        try {
            if (data === null || data === undefined) {
                jQuery('#resultDiv').html("No result from server");
            } else {
                callback(data);
            }
        } catch (e) {
            jQuery('#resultDiv').html(e);
        }
    });
    request.fail(function (textStatus, errorThrown) {
        jQuery('#resultDiv').html(errorThrown + " status=" + textStatus.status);
    });
}

function getAllQuestion() {
    rest(questionRestUrl, 'GET', null, null, 'json', renderGetAll)
}

function getQuestionByQuery() {
    var url = $("#queryUrl").val();
    rest(questionRestUrl + url, 'GET', null, null, 'json', renderQueryGet);
}

function getQuestionByPath() {
    var url = $("#pathUrl").val();
    rest(questionRestUrl + url, 'GET', null, null, 'json', renderPathGet);
}

function renderGetQuestion(data) {
    $('#resultDiv').html("query result:" + data);
}

function renderGetAll(data) {
    var questions = data.questionList.question;
    var result = "";
    for (var i = 0; i < books.length; i++) {
        result += questions[i].id + "-A:" + questions[i].A + "-B:" + questions[i].B + "-C:" + questions[i].C +
            "-D:" + questions[i].D + "-content:" + questions[i].content + "-correct:" + questions[i].correct + "-description:" +
            questions[i].description + "-topic:" + questions[i].topic + "<br/>";
    }
    $('#resultDiv').html(result);
}

function renderQueryGet(data) {
    $('#resultDiv').html("query result:" + data.id + "-A:" + data.A + "-B:" + data.B + "-C:" + data.C +
        "-D:" + data.D + "-content:" + data.content + "-correct:" + data.correct + "-description:" +
        data.description + "-topic:" + data.topic + "<br/>");
}

function renderPathGet(data) {
    $('#resultDiv').html("query result:" + data.id + "-A:" + data.A + "-B:" + data.B + "-C:" + data.C +
        "-D:" + data.D + "-content:" + data.content + "-correct:" + data.correct + "-description:" +
        data.description + "-topic:" + data.topic + "<br/>");
}
