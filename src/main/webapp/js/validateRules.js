$.extend($.fn.validatebox.defaults.rules, {
    minLength: {
        validator: function(value, param){
            return value.length >= param[0];
        },
        message: 'Please enter at least {0} characters.'
    }
});

//useage: <input class="easyui-validatebox" data-options="validType:'minLength[5]'">