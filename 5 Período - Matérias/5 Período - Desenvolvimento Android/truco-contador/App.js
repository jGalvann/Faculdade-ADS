import { useState } from "react";
import { StyleSheet, Text, View, Button } from "react-native";

export default function App() {
  const [pontuacaoNos, setPontuacaoNos] = useState(0);
  const [pontuacaoEles, setPontuacaoEles] = useState(0);

  return (
    <View style={styles.container}>
      <View style={styles.containerBotao}>
        <Text style={styles.titulo}> Nós</Text>
        <Text style={styles.numero}>{pontuacaoNos}</Text>

        <View style={styles.fileiraBotao}>
          <View style={styles.botao}>
            <Button
              color="#01633d"
              title="+"
              onPress={() => setPontuacaoNos(pontuacaoNos + 1)}
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
            onPress={() => setPontuacaoNos(pontuacaoNos + 3)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#022363"
            title="SEISSS"
            onPress={() => setPontuacaoNos(pontuacaoNos + 6)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#4F0263"
            title="NOVEEE"
            onPress={() => setPontuacaoNos(pontuacaoNos + 9)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#630102"
            title="DOZI"
            onPress={() => setPontuacaoNos(pontuacaoNos + 12)}
          />
        </View>
      </View>

      <View style={styles.containerBotao}>
        <Text style={styles.titulo}> Eles</Text>
        <Text style={styles.numero}>{pontuacaoEles}</Text>

        <View style={styles.fileiraBotao}>
          <View style={styles.botao}>
            <Button
              color="#01633d"
              title="+"
              onPress={() => setPontuacaoEles(pontuacaoEles + 1)}
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
            onPress={() => setPontuacaoEles(pontuacaoEles + 3)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#022363"
            title="SEISSS"
            onPress={() => setPontuacaoEles(pontuacaoEles + 6)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#4F0263"
            title="NOVEEE"
            onPress={() => setPontuacaoEles(pontuacaoEles + 9)}
          />
        </View>

        <View style={styles.botaoEspecial}>
          <Button
            color="#630102"
            title="DOZI"
            onPress={() => setPontuacaoEles(pontuacaoEles + 12)}
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
    marginBottom: 50,
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
});
