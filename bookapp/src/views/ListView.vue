<template>
  <div class="home">
    <h1>LIST PAGE</h1>
    <div v-if="books.length">
      <MyBook
        v-for="book in books"
        :key="book.isbn"
        :book="book"
        @delete="reload"
      />
    </div>
    <div>
      <button @click="create">CREATE BOOK</button>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import MyBook from "@/components/MyBook.vue";
import axios from "axios";

export default {
  name: "ListView",
  components: {
    MyBook,
  },
  data() {
    return {
      books: Object,
    };
  },
  methods: {
    create() {
      this.$router.push("create");
    },
    reload() {
      axios({
        method: "get",
        url: "http://localhost:8080/bookapi/book/",
      }).then((res) => {
        this.books = res.data;
      });
    },
  },
  created() {
    axios({
      method: "get",
      url: "http://localhost:8080/bookapi/book/",
    }).then((res) => {
      this.books = res.data;
    });
  },
};
</script>
