<script>
    $(document).ready(function () {
        $('#mySelect').select2({
            templateResult: function (data) {
                var iconClass = '';
                if (data.id === 'DRIVING') {
                    iconClass = 'fa-solid fa-car';
                } else if (data.id === 'WALKING') {
                    iconClass = 'fa-solid fa-person-walking';
                } else if (data.id === 'BICYCLING') {
                    iconClass = 'fa-solid fa-bicycle';
                } else if (data.id === 'TRANSIT') {
                    iconClass = 'fa-solid fa-bus';
                }

                var $result = $('<span><i class="' + iconClass + '"></i> ' + data.text + '</span>');
                return $result;
            }
        });
    });
</script>
