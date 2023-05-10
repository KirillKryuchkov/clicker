Vue.component('button-counter', {
    props : ['count'],
    template: '<button @click="submitClick">Счётчик кликов — {{ count }}</button>',
    created: function () {
        axios.get('/rest/clicks')
            .then(response => (this.count = response.data))
    },
    methods: {
        submitClick: function () {
            axios.post('/rest/click')
                .then(response => (this.count = response.data))
        }
    }

});
const app = new Vue({
    el: '#app',
    template: '<button-counter/>'
});