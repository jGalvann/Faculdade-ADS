import { useState } from "react";
import { StyleSheet, Text, View, Button } from "react-native";

export default function App() {
  const [pontuacaoNos, setPontuacaoNos] = useState(0);
  const [pontuacaoEles, setPontuacaoEles] = useState(0);
  const [vitoriaNos, setVitoriaNos] = useState(0);
  const [vitoriaEles, setVitoriaEles] = useState(0);

  const adicionarPontosNos = (pontos) => {
    let novaPontuacao = pontuacaoNos + pontos;
    if (novaPontuacao >= 12) {
      setPontuacaoNos(0);
      setPontuacaoEles(0);
      setVitoriaNos(vitoriaNos + 1);
    } else {
      setPontuacaoNos(novaPontuacao);
    }
  }

  const adicionarPontosEles = (pontos) => {
    let novaPontuacao = pontuacaoEles + pontos;
    if (novaPontuacao >= 12) {
      setPontuacaoNos(0);
      setPontuacaoEles(0);
      setVitoriaEles(vitoriaEles + 1);
    } else {
      setPontuacaoEles(novaPontuacao);
    }
    
  }


  return (
    <View style={styles.container}>

      <View style={styles.containerBotao}>
        <Text style={styles.titulo}> Nós</Text>
        <Text style={styles.numero}>{pontuacaoNos}</Text>
        <Text style={styles.wins}> Ganhou: {vitoriaNos} </Text>

        <View style={styles.fileiraBotao}>
          <View style={styles.botao}>
            <Button
              color="#01633d"
              title="+"
              onPress={() => adicionarPontosNos(1)}
            />
          </View>

          <View style={styles.botao}>
            <Button
              color="#87092a"
              title="-"
              onPress={() =>
                setPontuacaoNos(pontuacaoNos > 0 ? pontuacaoNos - 1 : 0)
              }
            />
          </View>
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#015B61"
            title="TRUCO"
            onPress={() => adicionarPontosNos(3)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#022363"
            title="SEISSS"
            onPress={() => adicionarPontosNos(6)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#4F0263"
            title="NOVEEE"
            onPress={() => adicionarPontosNos(9)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#630102"
            title="DOZI"
            onPress={() => adicionarPontosNos(12)}
          />
        </View>
      </View>

      <View style={styles.containerBotao}>
        <Text style={styles.titulo}> Eles</Text>
        <Text style={styles.numero}>{pontuacaoEles}</Text>
        <Text style={styles.wins}> Ganhou: {vitoriaEles} </Text>

        <View style={styles.fileiraBotao}>
          <View style={styles.botao}>
            <Button
              color="#01633d"
              title="+"
              onPress={() => adicionarPontosEles(3)}
            />
          </View>

          <View style={styles.botao}>
            <Button
              color="#87092a"
              title="-"
              onPress={() =>
                setPontuacaoEles(pontuacaoEles > 0 ? pontuacaoEles - 1 : 0)
              }
            />
          </View>
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#015B61"
            title="TRUCO"
            onPress={() => adicionarPontosEles(3)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#022363"
            title="SEISSS"
            onPress={() => adicionarPontosEles(6)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#4F0263"
            title="NOVEEE"
            onPress={() => adicionarPontosEles(9)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#630102"
            title="DOZI"
            onPress={() => adicionarPontosEles(12)}
          />
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    flexDirection: "row",
    backgroundColor: "#fff",
    alignItems: "center",
  },
  titulo: {
    fontSize: 26,
    fontWeight: "bold",
    marginBottom: 5,
  },
  numero: {
    fontSize: 100,
    fontWeight: "bold",
    color: "#333",
    marginBottom: 0,
  },
  containerBotao: {
    flex: 1,
    width: "50%",
    alignItems: "center",
    justifyContent: "center",
  },
  botao: {
    width: 60,
    marginHorizontal: 10,
  },
  fileiraBotao: {
    flexDirection: "row",
    justifyContent: "center",
    width: "60%",
  },
  botaoEspecial: {
    width: "67%",
    marginVertical: 5,
  },
  wins: {
    fontSize: 18,
    marginBottom: 50,
    fontWeight: "bold",
  },

});
