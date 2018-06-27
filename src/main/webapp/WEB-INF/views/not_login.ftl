<script type="text/javascript">
    var ctx="${ctx}";
    if("${uri}"=="main"){
        window.location.href=ctx+"/index";
    }else{
        window.parent.location.href=ctx+"/index";
    }
</script>