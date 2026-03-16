
import { useState } from 'react';
import { StyleSheet, Text, View, Button } from 'react-native';


export default function App() {

  const [pontuacao, setPontuacao] = useState(0);


  return (
    <View style={styles.container}>
      
      <Text style={styles.titulo}> Marcador</Text>
      <Text style={styles.numero}>{pontuacao}</Text>

      <View style={styles.containerBotao}>
        <View style={styles.botao}>
        <Button 
        color="#01633d"
        title="+" 
        onPress={() => setPontuacao(pontuacao + 1)} 
        />  
      </View>

      <View style={styles.botao}>
        <Button 
        color="#87092a"
        title="-" 
        onPress={() => setPontuacao(pontuacao > 0 ? pontuacao - 1 : 0)} 
        />  
      </View>

      </View>


    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
  titulo: {
    fontSize: 26,
    fontWeight: 'bold',
    marginBottom: 5,
  },
  numero: {
    fontSize: 100,
    fontWeight: 'bold',
    color: '#333',
    marginBottom: 150,
  },
  containerBotao: {
    flexDirection: 'row',
    gap: 20,
  },
  botao: {
    width: 100,
    height: 100,
    
  },


});
