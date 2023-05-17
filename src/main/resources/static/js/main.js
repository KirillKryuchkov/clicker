Vue.component('button-counter', {
    props: ['count'],
    template: '<div><button @click="submitClick">Счётчик кликов — {{ count }}</button>\n' +
              '<button @click="resetClicks">Сбросить</button></div>',
    created: function () {
        axios.get('/rest/clicks')
            .then(response => (this.count = response.data))
    },
    methods: {
        submitClick: function () {
            axios.post('/rest/click')
                .then(response => (this.count = response.data))
        },
        resetClicks: function () {
            axios.delete('/rest/clicks').
            then(response => (this.count = response.data))
        }
    }
});
const app = new Vue({
    el: '#app',
    template: '<button-counter/>'
});
