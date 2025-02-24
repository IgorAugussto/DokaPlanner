<template>
  <div class="flex items-center justify-center h-screen bg-gray-100">
    <!-- Botão para abrir o modal -->
    <button
      @click="toggleModal"
      class="px-4 py-2 text-white bg-blue-600 rounded-lg hover:bg-blue-700"
    >
      Cadastrar Visitante
    </button>

    <!-- Modal -->
    <div
      v-if="showModal"
      class="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50"
    >
      <div class="bg-white p-6 rounded-lg shadow-lg w-full max-w-md">
        <!-- Cabeçalho do Modal -->
        <div class="flex justify-between items-center mb-4">
          <h2 class="text-lg font-semibold">Cadastrar Visitante</h2>
          <button @click="toggleModal" class="text-gray-400 hover:text-gray-600">&times;</button>
        </div>

        <!-- Formulário -->
        <form class="space-y-4">
          <div>
            <label for="date" class="block text-sm font-medium">Data de chegada</label>
            <input
              type="date"
              id="date"
              class="w-full p-2 border rounded-lg"
            />
          </div>

          <div>
            <label for="name" class="block text-sm font-medium">Nome</label>
            <input
              type="text"
              id="name"
              class="w-full p-2 border rounded-lg"
            />
          </div>

          <div>
            <label class="block text-sm font-medium">Sexo</label>
            <select class="w-full p-2 border rounded-lg">
              <option>Masculino</option>
              <option>Feminino</option>
            </select>
          </div>

          <div>
            <label for="phone" class="block text-sm font-medium">Telefone</label>
            <input
              type="tel"
              id="phone"
              class="w-full p-2 border rounded-lg"
            />
          </div>

          <div>
            <label class="block text-sm font-medium">Participa de outra igreja?</label>
            <div class="flex items-center space-x-4">
              <label>
                <input
                  type="radio"
                  name="otherChurchParticipation"
                  value="Sim"
                  v-model="participatesInOtherChurch"
                  class="mr-2"
                />
                Sim
              </label>
              <label>
                <input
                  type="radio"
                  name="otherChurchParticipation"
                  value="Não"
                  v-model="participatesInOtherChurch"
                  class="mr-2"
                />
                Não
              </label>
            </div>
          </div>

          <!-- Campo adicional para "Qual igreja?" -->
          <div v-if="participatesInOtherChurch === 'Sim'">
            <label for="otherChurchName" class="block text-sm font-medium">Qual igreja?</label>
            <input
              type="text"
              id="otherChurchName"
              class="w-full p-2 border rounded-lg"
            />
          </div>

          <div>
            <label for="how" class="block text-sm font-medium">Como conheceu a igreja?</label>
            <input
              type="text"
              id="how"
              class="w-full p-2 border rounded-lg"
            />
          </div>

          <div>
            <label class="block text-sm font-medium">Ministério</label>
            <select class="w-full p-2 border rounded-lg">
              <option>Doka</option>
              <option>Wave</option>
              <option>+Perto</option>
            </select>
          </div>

          <!-- Botões -->
          <div class="flex justify-end space-x-2">
            <button
              type="button"
              @click="toggleModal"
              class="px-4 py-2 text-white bg-gray-600 rounded-lg hover:bg-gray-700"
            >
              Cancelar
            </button>
            <button
              type="submit"
              class="px-4 py-2 text-white bg-blue-600 rounded-lg hover:bg-blue-700"
            >
              Salvar
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'; // Importando `ref` para controle reativo do estado

// Controle de visibilidade do modal
const showModal = ref(false);

// Controle da resposta para "Participa de outra igreja?"
const participatesInOtherChurch = ref<string>('Não');

// Função para alternar o estado do modal
const toggleModal = () => {
  showModal.value = !showModal.value;
};
</script>

<style>
body {
  font-family: 'Arial', sans-serif;
}
</style>
